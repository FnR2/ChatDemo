package com.bedir.chatdemo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.bedir.entity.Message
import com.bedir.usecase.GetChatMessageResult
import com.bedir.usecase.GetChatMessagesUseCase
import com.bedir.usecase.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessagingViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val getChatMessagesUseCase: GetChatMessagesUseCase,
    private val mapper: ItemMapper
) : DemoViewModel<MessagingState>(
    MessagingState.IdleState(
        id = savedStateHandle.get<ChatScreenArg>(
            "arg"
        )!!.id,
        name = savedStateHandle.get<ChatScreenArg>(
            "arg"
        )!!.name
    )
) {


    fun getMessages() {
        viewModelScope.launch {
            getChatMessagesUseCase.execute(getState().id.toInt()).collect { result ->
                when (result) {
                    is GetChatMessageResult.Error -> {
                        //TODO handle error
                    }

                    is GetChatMessageResult.Success -> {
                        setNewState(
                            MessagingState.Success(
                                name = getState().name,
                                id = getState().id,
                                messageList = mapper.mapMessages(result.messages)
                            )
                        )
                    }
                }

            }
        }
    }

    fun sendMessage(message: String) {
        if (message.isNotBlank()) {
            viewModelScope.launch {
                sendMessageUseCase.execute(
                    Message(
                        messageId = 0,
                        text = message,
                        ownerChatId = getState().id.toInt()
                    )
                ).collect {

                }
            }

        }

    }

}

sealed class MessagingState(
    open val name: String,
    open val id: String,
    open val messageList: List<MessageItemModel>
) : State {
    data class IdleState(override val name: String, override val id: String) :
        MessagingState(name, id, emptyList())

    data class Success(
        override val name: String,
        override val id: String,
        override val messageList: List<MessageItemModel>
    ) :
        MessagingState(name, id, messageList)

}