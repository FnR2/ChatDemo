package com.bedir.chatdemo

interface Event

data class NavigateChatEvent(val chatId:String):Event