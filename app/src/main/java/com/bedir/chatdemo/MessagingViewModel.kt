package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.SendMessageUseCase
import com.bedir.usecase.StartChatUseCase
import kotlinx.coroutines.launch

class MessagingViewModel(
    private val sendMessageUseCase: SendMessageUseCase
) : DemoViewModel<MessagingState>(MessagingState.Success) {

    fun sendMessage() {
        viewModelScope.launch {

        }

    }

}

sealed class MessagingState() : State {
    data object Success : MessagingState()
}