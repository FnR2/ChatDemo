package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class StartChatUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(chat: Chat): Flow<StartChatResult> {
        return flow {
            val check = repository.checkItemExist(chat.name)
            if (check) {
                emit(StartChatResult.ChatExist)
            } else {
                repository.startChat(chat)
                emit(StartChatResult.Success)
            }

        }.catch {
            emit(StartChatResult.Error(it))
        }.map {
            it
        }.flowOn(Dispatchers.IO)

    }
}

sealed class StartChatResult : UseCaseResult {
    data class Error(val error: Throwable) : StartChatResult()
    object ChatExist : StartChatResult()
    object Success : StartChatResult()
}