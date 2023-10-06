package com.bedir.data

import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ChatRepository(
    private val chatDao: DefaultChatDao
) {
    suspend fun getAllChats(): Flow<Result<List<ChatWithMessages>>> {
        return flow<List<ChatWithMessages>> {
            chatDao.getAllChats()
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun getChatMessages(chatId: Int): Flow<Result<List<Message>>> {
        return flow<List<Message>> {
            chatDao.getChatMessages(chatId)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun changeMuteSettings(isMuted: Boolean, chatId: Int): Flow<Result<Long>> {
        return flow<Long> {
            chatDao.changeMute(chatId, isMuted)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun deleteChat(chatId: Int): Flow<Result<Long>> {
        return flow<Long> {
            chatDao.deleteChat(chatId)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun startChat(name: String): Flow<Result<Long>> {
        return flow<Long> {
            chatDao.createNewChat(name)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun sendMessage(chatId: Int, message: String): Flow<Result<Long>> {
        return flow<Long> {
            chatDao.insertMessage(chatId, message)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }
}