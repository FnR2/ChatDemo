package com.bedir.chatdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bedir.chatdemo.databinding.FragmentChatListBinding

class ChatListFragment : DemoFragment<FragmentChatListBinding>() {
    override fun binding(inflater: LayoutInflater, container: ViewGroup?): FragmentChatListBinding {
        return FragmentChatListBinding.inflate(inflater, container, false)
    }

    override fun render(state: State) {

    }
}