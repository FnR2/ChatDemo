package com.bedir.chatdemo

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bedir.entity.Chat
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.StartChatResult
import com.bedir.usecase.StartChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
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
                    chatId = 0,
                    name = chatName,
                    isMuted = false,
                    createdAt = 0f,
                    lastMessage = ""
                )
            ).collect { result ->
                when (result) {
                    is StartChatResult.ChatExist -> {
                        setNewState(NewChatViewState.ChatExist)
                    }

                    is StartChatResult.Error -> {
                        //TODO error handling
                    }

                    is StartChatResult.Success -> {
                        setNewState(NewChatViewState.Success)
                    }
                }

            }
        }

    }

}

sealed class NewChatViewState : State {
    object IdleState : NewChatViewState()
    object Success : NewChatViewState()
    object ChatExist : NewChatViewState()

}