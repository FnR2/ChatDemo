package com.bedir.room

import androidx.room.Embedded
import androidx.room.Relation

data class ChatWithMessages(
    @Embedded
    val chat: Chat,
    @Relation(
        parentColumn = "chatId",
        entityColumn = "messageId"
    )
    val messageList: List<Message>
)
