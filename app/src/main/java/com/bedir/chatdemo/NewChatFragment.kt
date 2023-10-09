package com.bedir.chatdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bedir.chatdemo.databinding.FragmentChatListBinding
import com.bedir.chatdemo.databinding.FragmentNewChatBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewChatFragment : DemoFragment<FragmentNewChatBinding>() {

    private val viewModel: ChatListViewModel by viewModels()

    @Inject
    lateinit var chatAdapter: ChatListAdapter
    override fun binding(inflater: LayoutInflater, container: ViewGroup?): FragmentNewChatBinding {
        return FragmentNewChatBinding.inflate(inflater, container, false)
    }

    override fun render(state: State) {

    }

    override fun handleEvent(event: Event) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeFlow(viewModel.getStateHolder())
    }

    override fun onEvent(event: Event) {

    }
}