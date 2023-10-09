package com.bedir.data

import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow

interface DefaultChatDao {
    suspend fun createNewChat(chat: Chat): Long
    suspend fun changeMute(chat: Chat): Int
    suspend fun deleteChat(chatId:Int): Int
    suspend fun getAllChats(): Flow<List<ChatWithMessages>>
    suspend fun getChatMessages(chatId:Int): Flow<List<Message>>
    suspend fun insertMessage(message: Message): Long
    suspend fun checkItemExist(name:String):Boolean
}