package com.bedir.chatdemo

interface EventPublisher {
    fun sendEvent(event: Event)
}