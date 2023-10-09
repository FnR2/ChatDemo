package com.bedir.data

import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class ChatRepository(
    private val chatDao: DefaultChatDao
) {
    suspend fun getAllChats(): Flow<Result<List<ChatWithMessages>>> {

        return chatDao.getAllChats().map {
            Result.success(it)
        }.catch {
            Result.failure<ChatWithMessages>(it)
        }.flowOn(Dispatchers.IO)

    }

    suspend fun getChatMessages(chatId: Int): Flow<Result<List<Message>>> {
        return chatDao.getChatMessages(chatId)
            .map {
                Result.success(it)
            }.catch {
                emit(Result.failure(it))
            }
    }

    suspend fun changeMuteSettings(chat: Chat): Flow<Result<Int>> {
        return flow<Int> {
            emit(chatDao.changeMute(chat))
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun deleteChat(chatId: Int): Flow<Result<Int>> {
        return flow<Int> {
            chatDao.deleteChat(chatId)
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }

    suspend fun startChat(chat: Chat): Long {
        return chatDao.createNewChat(chat)
    }

    suspend fun sendMessage(message: Message): Flow<Result<Long>> {
        return flow<Long> {
            emit(chatDao.insertMessage(message))
        }.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun checkItemExist(name: String): Boolean {
        return chatDao.checkItemExist(name)
    }
}