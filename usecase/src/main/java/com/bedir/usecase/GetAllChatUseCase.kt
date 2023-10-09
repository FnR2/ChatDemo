package com.bedir.usecase

import com.bedir.data.ChatRepository
import com.bedir.entity.ChatWithMessages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetAllChatUseCase(
    private val repository: ChatRepository
) : UseCase {

    suspend fun execute(): Flow<AllChatsResult> {
        return repository.getAllChats().map { result ->
            result.fold(onSuccess = {
                if (it.isNotEmpty()) {
                    AllChatsResult.Success(it)
                } else {
                    AllChatsResult.Empty
                }
            }, onFailure = {
                AllChatsResult.Error(it)
            })
        }
    }
}

sealed class AllChatsResult : UseCaseResult {
    data class Success(val chatList: List<ChatWithMessages>) : AllChatsResult()
    object Empty : AllChatsResult()
    data class Error(val error: Throwable) : AllChatsResult()
}