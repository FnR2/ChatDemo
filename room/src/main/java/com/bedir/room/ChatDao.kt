package com.bedir.room

import androidx.room.*
import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun createChat(name:String): Flow<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun changeMute(id: Int,isMuted:Boolean):Flow<Long>

    @Transaction
    @Query("DELETE FROM Chat WHERE chat_id = :id")
    abstract suspend fun deleteChat(id: Int): Flow<Long>

    @Transaction
    @Query(
        "SELECT  * FROM Chat"
    )
    abstract suspend fun getAllChats(
    ): Flow<List<ChatWithMessages>>

    @Transaction
    @Query(
        "SELECT  * FROM Chat WHERE chat_id = :id"
    )
    abstract suspend fun getChatMessages(id: Int
    ): Flow<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertMessage(text:String,chatId:Int): Flow<Long>


}
