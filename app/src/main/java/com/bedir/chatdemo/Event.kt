package com.bedir.chatdemo

interface Event

object LoadingEvent:Event
object CompletedEvent:Event
data class ErrorEvent(val error: Throwable):Event