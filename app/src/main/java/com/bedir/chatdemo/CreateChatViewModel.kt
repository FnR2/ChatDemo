package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.StartChatUseCase
import kotlinx.coroutines.launch

class CreateChatViewModel(
    private val startChatUseCase: StartChatUseCase
) : DemoViewModel<CreateChatState>(CreateChatState.Success) {

    fun createChat() {
        viewModelScope.launch {

        }

    }

}

sealed class CreateChatState() : State {
    data object Success : CreateChatState()
}