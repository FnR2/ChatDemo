package com.bedir.chatdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bedir.chatdemo.databinding.ChatListItemBinding
import com.bedir.chatdemo.databinding.MessageItemBinding

class MessagingAdapter(
    private val eventPublisher: EventPublisher
) :
    ListAdapter<MessageItemModel, MessagingViewHolder>(
        diffCallback
    ) {

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<MessageItemModel>() {
            override fun areItemsTheSame(
                oldItem: MessageItemModel,
                newItem: MessageItemModel
            ): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: MessageItemModel,
                newItem: MessageItemModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagingViewHolder {
        val binding: MessageItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.message_item,
            parent,
            false
        )
        return MessagingViewHolder(binding, eventPublisher)
    }

    override fun onBindViewHolder(holder: MessagingViewHolder, position: Int) {
        val item: MessageItemModel = getItem(position)!!
        holder.bind(item)
    }


}