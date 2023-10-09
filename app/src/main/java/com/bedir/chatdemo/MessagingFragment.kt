package com.bedir.chatdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bedir.chatdemo.databinding.FragmentMessagingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MessagingFragment : DemoFragment<FragmentMessagingBinding>() {

    private val viewModel: MessagingViewModel by viewModels()

    @Inject
    lateinit var adapter: MessagingAdapter
    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessagingBinding {
        return FragmentMessagingBinding.inflate(inflater, container, false)
    }

    override fun render(state: State) {
        when (state as MessagingState) {
            is MessagingState.IdleState -> {
                viewBinding.appbar.setTitle(state.name)
            }

            is MessagingState.Success -> {
                adapter.submitList(state.messageList)
            }
        }
    }

    override fun handleEvent(event: Event) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeFlow(viewModel.getStateHolder())
        with(viewBinding) {
            appbar.setTitle(getString(R.string.create_button))
            viewModel.getMessages()
            rvChats.adapter = adapter
            btnSend.setOnClickListener {
                viewModel.sendMessage(etMessage.text.toString())
                etMessage.text.clear()
            }

        }
    }
}