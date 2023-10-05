package com.bedir.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertChat(item: ChatWithMessages): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun changeMute(item: Chat)

    @Transaction
    @Query("DELETE FROM Chat WHERE chat_id = :id")
    abstract fun deleteChat(id: Long): Int

    @Transaction
    @Query(
        "SELECT  * FROM Chat"
    )
    abstract fun getAllChats(
    ): Flow<List<ChatWithMessages>>


}
