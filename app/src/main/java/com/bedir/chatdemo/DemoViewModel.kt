package com.bedir.chatdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class DemoViewModel<S:State>(
    idleState: S
) : ViewModel() {
    private val stateHolder: MutableStateFlow<State> = MutableStateFlow(idleState)
    fun setNewState(state: State) {
        stateHolder.value = state
    }

    fun <T> getState() = stateHolder.value as S

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    private val eventsFlow = eventChannel.receiveAsFlow()

    fun sendEvent(event: Event) {
        viewModelScope.launch {
            eventChannel.send(event)
        }

    }

    fun getEvents() = eventsFlow
    fun getStateHolder() = stateHolder
}