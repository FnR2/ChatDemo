package com.bedir.room

import androidx.room.*
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message

@Dao
abstract class ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createChat(item: Chat): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun changeMute(chat: Chat): Int

    @Transaction
    @Query("DELETE FROM Chat WHERE chatId = :id")
    abstract fun deleteChat(id: Int): Int

    @Transaction
    @Query(
        "SELECT  * FROM Chat"
    )
    abstract fun getAllChats(
    ): List<ChatWithMessages>

    @Transaction
    @Query(
        "SELECT  * FROM MESSAGE WHERE ownerChatId = :id"
    )
    abstract fun getChatMessages(
        id: Int
    ): List<Message>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMessage(message: Message): Long


}
