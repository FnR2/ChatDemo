package com.bedir.chatdemo

import com.bedir.entity.Chat
import com.bedir.entity.ChatWithMessages

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
}