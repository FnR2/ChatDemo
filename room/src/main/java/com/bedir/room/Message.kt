package com.bedir.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
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
    val ownerChatId: Int
)
