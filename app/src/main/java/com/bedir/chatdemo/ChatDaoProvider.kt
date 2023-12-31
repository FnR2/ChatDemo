package com.bedir.chatdemo

import com.bedir.data.DefaultChatDao
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import com.bedir.room.ChatDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class ChatDaoProvider @Inject constructor(
    private val chatDao: ChatDao
) : DefaultChatDao {
    override suspend fun createNewChat(chat: Chat): Long {
        return chatDao.insertChat(chat)
    }

    override suspend fun changeMute(chat: Chat): Int {
        return chatDao.changeMute(chat)
    }

    override suspend fun deleteChat(chatId: Int): Int {
        return chatDao.deleteChat(chatId)
    }

    override suspend fun getAllChats(): Flow<List<ChatWithMessages>> {
        return chatDao.getAllChats()
    }

    override suspend fun getChatMessages(chatId: Int): Flow<List<Message>> {
        return chatDao.getChatMessages(chatId)
    }

    override suspend fun insertMessage(message: Message): Long {
        return chatDao.createMessage(message)
    }

    override suspend fun checkItemExist(name: String): Boolean {
        return chatDao.checkItemExist(name)
    }
}