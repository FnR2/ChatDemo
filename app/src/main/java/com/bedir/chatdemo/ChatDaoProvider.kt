package com.bedir.chatdemo

import com.bedir.data.DefaultChatDao
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import com.bedir.room.ChatDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatDaoProvider @Inject constructor(
    private val chatDao: ChatDao
) : DefaultChatDao {
    override suspend fun createNewChat(name: String): Flow<Long> {
        return chatDao.createChat(name)
    }

    override suspend fun changeMute(chatId: Int, isMuted: Boolean): Flow<Long> {
        return chatDao.changeMute(chatId, isMuted)
    }

    override suspend fun deleteChat(chatId: Int): Flow<Long> {
        return chatDao.deleteChat(chatId)
    }

    override suspend fun getAllChats(): Flow<List<ChatWithMessages>> {
        return chatDao.getAllChats()
    }

    override suspend fun getChatMessages(chatId: Int): Flow<List<Message>> {
        return chatDao.getChatMessages(chatId)
    }

    override suspend fun insertMessage(chatId: Int, text: String): Flow<Long> {
        return chatDao.insertMessage(text, chatId)
    }
}