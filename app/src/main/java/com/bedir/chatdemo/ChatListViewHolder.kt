package com.bedir.chatdemo


import androidx.recyclerview.widget.RecyclerView
import com.bedir.chatdemo.databinding.ChatListItemBinding

class ChatListViewHolder(
    private val binding: ChatListItemBinding,
    private val eventPublisher: EventPublisher
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: ChatItemModel) {
        with(binding) {
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
            root.setOnClickListener {
                eventPublisher.sendEvent(NavigateChatEvent(viewModel.id, viewModel.name))
            }
            root.setOnLongClickListener {
                eventPublisher.sendEvent(ChatDeleteEvent)
                true
            }
        }

    }
}