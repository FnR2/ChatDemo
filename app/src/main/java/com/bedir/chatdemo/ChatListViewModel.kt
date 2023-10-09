package com.bedir.chatdemo

import androidx.lifecycle.viewModelScope
import com.bedir.usecase.AllChatsResult
import com.bedir.usecase.GetAllChatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(
    private val chatListUseCase: GetAllChatUseCase,
    private val itemMapper: ItemMapper
) : DemoViewModel<ChatListState>(ChatListState.IdleState) {

     fun getChatList() {
        viewModelScope.launch {
            chatListUseCase.execute().collect { result ->
                when (result) {
                    AllChatsResult.Empty -> {

                    }

                    is AllChatsResult.Error -> {

                    }

                    is AllChatsResult.Success -> {

                    }
                }
            }
        }

    }

}

sealed class ChatListState() : State {
    object IdleState : ChatListState()
}