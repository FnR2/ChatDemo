package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class StartChatUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(chat: Chat): Flow<StartChatResult> {
      return repository.checkItemExist(chat.name).map {
            it.fold(onSuccess = {
                StartChatResult.ChatExist
            }, onFailure = {
                StartChatResult.ChatExist
            })
        }
        /*checkResult.map { res ->
            res.fold(onSuccess = { exist ->
                if (exist) {
                    emit(StartChatResult.ChatExist)
                } else {
                    repository.startChat(chat).map { insert ->
                        insert.fold(onSuccess = {
                            emit(StartChatResult.Success)
                        }, onFailure = {
                            emit(StartChatResult.Error(it))
                        })
                    }
                }
            }, onFailure = {
                emit(StartChatResult.Error(it))
            })

        }*/


    }
}

sealed class StartChatResult : UseCaseResult {
    data class Error(val error: Throwable) : StartChatResult()
    object ChatExist : StartChatResult()
    object Success : StartChatResult()
}