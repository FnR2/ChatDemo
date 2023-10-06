package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.ChatWithMessages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StartChatUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(name: String): Flow<StartChatResult> {
        return repository.startChat(name).map { result ->
            result.fold(onSuccess = {
                StartChatResult.Success(it)
            }, onFailure = {
                StartChatResult.Error(it)
            })
        }
    }
}

sealed class StartChatResult : UseCaseResult {
    data class Success(val result: Long) : StartChatResult()
    data class Error(val error: Throwable) : StartChatResult()
}