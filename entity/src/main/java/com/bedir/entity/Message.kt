package com.bedir.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Chat::class,
        childColumns = ["messageId"],
        parentColumns = ["ownerChatId"]
    )]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    val messageId: Long,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Float,
    @ColumnInfo(name = "owner_chat")
    val ownerChatId: Int
)
