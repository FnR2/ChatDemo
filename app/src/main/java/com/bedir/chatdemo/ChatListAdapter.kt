package com.bedir.chatdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bedir.chatdemo.databinding.ChatListItemBinding

class ChatListAdapter(
    private val eventListener: EventListener
) :
    ListAdapter<ChatItemModel, ChatListViewHolder>(
        diffCallback
    ) {

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<ChatItemModel>() {
            override fun areItemsTheSame(
                oldItem: ChatItemModel,
                newItem: ChatItemModel
            ): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: ChatItemModel,
                newItem: ChatItemModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val binding: ChatListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.chat_list_item,
            parent,
            false
        )
        return ChatListViewHolder(binding, eventListener)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        val item: ChatItemModel = getItem(position)!!
        holder.bind(item)
    }


}