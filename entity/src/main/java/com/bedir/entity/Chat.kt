package com.bedir.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true )
    val chatId: Int,
    var name: String,
    val isMuted: Boolean,
    val createdAt:Float,
    val lastMessage:String


)