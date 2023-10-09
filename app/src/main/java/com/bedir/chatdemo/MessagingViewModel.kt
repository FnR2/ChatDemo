package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.SendMessageUseCase
import com.bedir.usecase.StartChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessagingViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase
) : DemoViewModel<MessagingState>(MessagingState.Success) {

    fun sendMessage() {
        viewModelScope.launch {

        }

    }

}

sealed class MessagingState() : State {
    object Success : MessagingState()
}