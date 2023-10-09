package com.bedir.chatdemo

import androidx.lifecycle.asLiveData
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
) : DemoViewModel<ChatListState>(ChatListState.IdleState(emptyList())) {

    fun getChatList() {
        viewModelScope.launch {
            chatListUseCase.execute().collect { result ->
                when (result) {
                    AllChatsResult.Empty -> {
                        setNewState(ChatListState.Empty)
                    }

                    is AllChatsResult.Error -> {

                    }

                    is AllChatsResult.Success -> {
                        setNewState(ChatListState.Success(itemMapper.mapChatList(result.chatList)))
                    }
                }
            }
        }

    }

}

sealed class ChatListState(open val chatList: List<ChatItemModel>) : State {
    data class IdleState(override val chatList: List<ChatItemModel>) : ChatListState(chatList)
    object Empty : ChatListState(emptyList())
    data class Success(override val chatList: List<ChatItemModel>) : ChatListState(chatList)
}