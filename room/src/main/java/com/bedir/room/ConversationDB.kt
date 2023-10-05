package com.bedir.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bedir.entity.Chat
import com.bedir.entity.Message


@Database(entities = [Chat::class, Message::class], version = 1)
abstract class ConversationDB : RoomDatabase() {
    abstract fun getConversationDao(): ChatDao
}