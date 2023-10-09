package com.bedir.chatdemo


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bedir.chatdemo.databinding.ChatListItemBinding

class ChatListViewHolder(
    private val binding: ChatListItemBinding,
    private val eventListener: EventListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: ChatItemModel) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        binding.root.setOnClickListener {
            eventListener.onEvent(NavigateChatEvent(viewModel.id))
        }
    }
}