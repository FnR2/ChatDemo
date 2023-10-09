package com.bedir.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(indices = [Index(value = ["name"], unique = true)])
data class Chat(
    @PrimaryKey(autoGenerate = true )
    val chatId: Int = 0,
    var name: String,
    val isMuted: Boolean,
    var createdAt: Long = 0,

)