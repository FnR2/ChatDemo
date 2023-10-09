package com.bedir.chatdemo

import com.bedir.data.DefaultChatDao
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import com.bedir.room.ChatDao
import javax.inject.Inject

class ChatDaoProvider @Inject constructor(
    private val chatDao: ChatDao
) : DefaultChatDao {
    override suspend fun createNewChat(chat: Chat): Long {
        return chatDao.createChat(chat)
    }

    override suspend fun changeMute(chat: Chat): Int {
        return chatDao.changeMute(chat)
    }

    override suspend fun deleteChat(chatId: Int): Int {
        return chatDao.deleteChat(chatId)
    }

    override suspend fun getAllChats(): List<ChatWithMessages> {
        return chatDao.getAllChats()
    }

    override suspend fun getChatMessages(chatId: Int): List<Message> {
        return chatDao.getChatMessages(chatId)
    }

    override suspend fun insertMessage(message: Message): Long {
        return chatDao.insertMessage(message)
    }
}