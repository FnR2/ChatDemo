package com.bedir.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Chat::class,
        childColumns = ["ownerChatId"],
        parentColumns = ["chatId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    val messageId: Long,
    val text: String,
    val createdAt: Float,
    val ownerChatId: Int
)
