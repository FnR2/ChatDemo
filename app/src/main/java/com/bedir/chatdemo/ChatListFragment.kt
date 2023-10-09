package com.bedir.chatdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bedir.chatdemo.databinding.FragmentChatListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ChatListFragment : DemoFragment<FragmentChatListBinding>() {

    private val viewModel: ChatListViewModel by viewModels()

    @Inject
    lateinit var chatAdapter: ChatListAdapter
    override fun binding(inflater: LayoutInflater, container: ViewGroup?): FragmentChatListBinding {
        return FragmentChatListBinding.inflate(inflater, container, false)
    }

    override fun render(state: State) {

    }

    override fun handleEvent(event: Event) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeFlow(viewModel.getStateHolder())
            viewModel.getChatList()


        viewBinding.fabNew.setOnClickListener {
            findNavController().navigate(R.id.navigation_new_chat)
        }
    }

    override fun onEvent(event: Event) {

    }
}