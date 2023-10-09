package com.bedir.chatdemo

data class ChatItemModel(
    val id: String,
    val name: String,
    val lastMessage: String,
    val isMuted: Boolean,
)
