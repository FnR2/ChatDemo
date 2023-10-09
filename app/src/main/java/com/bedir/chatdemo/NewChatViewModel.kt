package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.entity.Chat
import com.bedir.usecase.StartChatResult
import com.bedir.usecase.StartChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewChatViewModel @Inject constructor(
    private val createChatUseCase: StartChatUseCase,
) : DemoViewModel<NewChatViewState>(NewChatViewState.IdleState) {

    fun createNewChat(chatName: String) {
        viewModelScope.launch {
            createChatUseCase.execute(
                Chat(
                    name = chatName,
                    isMuted = false,
                )
            ).collect { result ->
                when (result) {
                    is StartChatResult.ChatExist -> {
                        sendEvent(ChatExist)
                    }

                    is StartChatResult.Error -> {
                        //TODO error handling
                    }

                    is StartChatResult.Success -> {
                        sendEvent(ChatCreateSuccess)
                    }
                }

            }
        }

    }

}

sealed class NewChatViewState : State {
    object IdleState : NewChatViewState()

}