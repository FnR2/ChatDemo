package com.bedir.chatdemo

import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import java.time.Instant
import java.time.format.DateTimeFormatter


class ItemMapper(
    private val formatter: DateTimeFormatter
) {

    fun mapChatList(list: List<ChatWithMessages>): List<ChatItemModel> {
        return list.mapIndexed { index, chatWithMessages ->
            val lastMessage =
                if (chatWithMessages.messageList.isNotEmpty()) chatWithMessages.messageList.last() else null
            ChatItemModel(
                id = chatWithMessages.chat.chatId.toString(),
                name = chatWithMessages.chat.name,
                lastMessage = lastMessage?.text ?: "",
                isMuted = chatWithMessages.chat.isMuted,
                isLast = index == list.size - 1,
                lastMessageDate = lastMessage?.let {
                    convertTimeStamp(it.createdAt)
                } ?: ""
            )
        }
    }

    fun mapMessages(list: List<Message>): List<MessageItemModel> {
        return list.mapIndexed { index, message ->
            MessageItemModel(
                id = message.messageId.toString(),
                text = message.text,
                date = convertTimeStamp(message.createdAt),
                isLast = index == list.size - 1
            )
        }
    }

    private fun convertTimeStamp(timeStamp: Long): String {
        return formatter.format(
            Instant.ofEpochMilli(timeStamp)
        )
    }
}