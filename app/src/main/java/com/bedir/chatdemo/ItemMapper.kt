package com.bedir.chatdemo

import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message

class ItemMapper {
    fun mapChatList(list: List<ChatWithMessages>): List<ChatItemModel> {
        return list.map {
            ChatItemModel(
                id = it.chat.chatId.toString(),
                name = it.chat.name,
                lastMessage = "",
                isMuted = it.chat.isMuted
            )
        }
    }

    fun mapMessages(list: List<Message>): List<MessageItemModel> {
        return list.mapIndexed { index, message ->
            MessageItemModel(
                id = message.messageId.toString(),
                text = message.text,
                date = message.createdAt.toString(),
                isLast = index == list.size - 1
            )
        }
    }
}