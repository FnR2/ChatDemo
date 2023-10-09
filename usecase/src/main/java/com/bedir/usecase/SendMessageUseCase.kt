package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SendMessageUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(message: Message): Flow<SendMessageResult> {
        return repository.sendMessage(message).map { result ->
            result.fold(onSuccess = {
                SendMessageResult.Success(it)
            }, onFailure = {
                SendMessageResult.Error(it)
            })
        }
    }
}

sealed class SendMessageResult : UseCaseResult {
    data class Success(val result: Long) : SendMessageResult()
    data class Error(val error: Throwable) : SendMessageResult()
}