package com.bedir.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "chat_id")
    val chatId: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "is_muted")
    val isMuted: Boolean,
    @ColumnInfo(name="created_at")
    val createdAt:Float,
    @ColumnInfo(name ="last_message")
    val lastMessage:String


)