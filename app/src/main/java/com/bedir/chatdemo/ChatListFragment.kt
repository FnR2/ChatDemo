package com.bedir.chatdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
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

    private val clickListener =
        OnClickListener { findNavController().navigate(R.id.navigation_new_chat) }

    override fun render(state: State) {
        when (state as ChatListState) {
            ChatListState.Empty -> {
                with(viewBinding) {
                    rvChats.visibility = View.GONE
                    llEmpty.visibility = View.VISIBLE
                    fabNew.visibility = View.GONE
                }
            }

            is ChatListState.IdleState -> {
                //do nothing
            }

            is ChatListState.Success -> {
                with(viewBinding) {
                    rvChats.visibility = View.VISIBLE
                    llEmpty.visibility = View.GONE
                    fabNew.visibility = View.VISIBLE
                    chatAdapter.submitList(state.chatList)
                }
            }
        }
    }

    override fun handleEvent(event: Event) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            appbar.setTitle(getString(R.string.app_name))
            rvChats.adapter = chatAdapter
            fabNew.setOnClickListener(clickListener)
            btnNewChat.setOnClickListener(clickListener)
            fabNew.bringToFront()
        }
        subscribeFlow(viewModel.getStateHolder())
        viewModel.getChatList()
    }

    override fun onEvent(event: Event) {

    }
}