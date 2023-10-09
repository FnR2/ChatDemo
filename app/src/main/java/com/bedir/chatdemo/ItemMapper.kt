package com.bedir.chatdemo

import com.bedir.entity.Chat

class ItemMapper {
    fun mapChatList(list: List<Chat>): List<ChatItemModel> {
        return list.map {
            ChatItemModel(
                id = it.chatId.toString(),
                name = it.name,
                lastMessage = "",
                isMuted = it.isMuted
            )
        }
    }
}