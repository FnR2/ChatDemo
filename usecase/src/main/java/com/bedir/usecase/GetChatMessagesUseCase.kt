package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetChatMessagesUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(chatId: Int): Flow<GetChatMessageResult> {
        return repository.getChatMessages(chatId).map { result ->
            result.fold(onSuccess = {
                GetChatMessageResult.Success(it)
            }, onFailure = {
                GetChatMessageResult.Error(it)
            })
        }
    }
}

sealed class GetChatMessageResult : UseCaseResult {
    data class Success(val messages: List<Message>) : GetChatMessageResult()
    data class Error(val error: Throwable) : GetChatMessageResult()
}