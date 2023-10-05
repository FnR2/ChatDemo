package com.bedir.data

import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow

class ChatRepository(
    private val chatDao: DefaultChatDao
) {
    suspend fun getAllChats(): Flow<List<ChatWithMessages>> {
        return chatDao.getAllChats()
    }

    suspend fun getChatMessages(chatId: Int): Flow<List<Message>> {
        return chatDao.getChatMessages(chatId)
    }

    suspend fun changeMuteSettings(isMuted: Boolean, chatId: Int): Flow<Long> {
        return chatDao.changeMute(chatId, isMuted)
    }

    suspend fun deleteChat(chatId: Int):Flow<Long> {
        return chatDao.deleteChat(chatId)
    }
}