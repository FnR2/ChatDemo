package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.StartChatUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateChatViewModel @Inject constructor (
    private val startChatUseCase: StartChatUseCase
) : DemoViewModel<CreateChatState>(CreateChatState.Success) {

    fun createChat() {
        viewModelScope.launch {

        }

    }

}

sealed class CreateChatState() : State {
     object Success : CreateChatState()
}