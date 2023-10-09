package com.bedir.chatdemo


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ChatListViewHolder(
    private val binding: ViewDataBinding,
    private val eventListener: EventListener
) : RecyclerView.ViewHolder(binding.root) {

     fun bind(viewModel: ChatItemModel) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
    }
}