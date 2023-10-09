package com.bedir.chatdemo

interface Event

data class NavigateChatEvent(val chatId: String, val chatName: String) : Event
object ChatExist : Event
object ChatCreateSuccess : Event
object ChatDeleteEvent : Event

object ChatMuteEvent : Event