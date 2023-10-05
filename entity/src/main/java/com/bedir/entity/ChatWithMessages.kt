package com.bedir.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.bedir.entity.Chat

data class ChatWithMessages(
    @Embedded
    val chat: Chat,
    @Relation(
        parentColumn = "chatId",
        entityColumn = "ownerChatId"
    )
    val messageList: List<Message>
)
