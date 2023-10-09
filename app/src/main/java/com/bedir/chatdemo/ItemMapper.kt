package com.bedir.chatdemo

import com.bedir.entity.ChatWithMessages
import com.bedir.entity.Message
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class ItemMapper(
    private val formatter: DateTimeFormatter
) {

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