package com.bedir.data

import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow

interface DefaultChatDao {
    suspend fun createNewChat(name:String):Flow<Long>
    suspend fun changeMute(chatId:Int,isMuted:Boolean):Flow<Long>
    suspend fun deleteChat(chatId:Int):Flow<Long>
    suspend fun getAllChats():Flow<List<ChatWithMessages>>
    suspend fun getChatMessages(chatId:Int):Flow<List<Message>>
}