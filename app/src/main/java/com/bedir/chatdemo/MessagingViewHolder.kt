package com.bedir.chatdemo


import androidx.recyclerview.widget.RecyclerView
import com.bedir.chatdemo.databinding.ChatListItemBinding
import com.bedir.chatdemo.databinding.MessageItemBinding

class MessagingViewHolder(
    private val binding: MessageItemBinding,
    private val eventPublisher: EventPublisher
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: MessageItemModel) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        binding.root.setOnClickListener {
          //  eventPublisher.sendEvent(NavigateChatEvent(viewModel.id))
        }
    }
}