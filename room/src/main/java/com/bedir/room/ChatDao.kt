package com.bedir.room

import androidx.room.*
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChatDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    internal abstract fun createChat(item: Chat): Long

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
    ): Flow<List<ChatWithMessages>>

    @Transaction
    @Query(
        "SELECT  * FROM MESSAGE WHERE ownerChatId = :id"
    )
    abstract fun getChatMessages(
        id: Int
    ): Flow<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    internal abstract fun insertMessage(message: Message): Long

    @Query("SELECT EXISTS (SELECT * FROM chat WHERE name = :name)")
    abstract fun checkItemExist(name: String): Boolean

    fun insertChat(item: Chat): Long {
        return createChat(item.apply {
            createdAt = System.currentTimeMillis()
        })
    }

    fun createMessage(message: Message): Long {
        return insertMessage(message.apply {
            createdAt = System.currentTimeMillis()
        })
    }


}
