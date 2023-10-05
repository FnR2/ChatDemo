package com.bedir.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Chat::class, Message::class], version = 1)
abstract class ConversationDB : RoomDatabase() {
    abstract fun getConversationDao(): ChatDao
}