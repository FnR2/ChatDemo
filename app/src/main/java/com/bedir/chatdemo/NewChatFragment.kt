package com.bedir.chatdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bedir.chatdemo.databinding.FragmentChatListBinding
import com.bedir.chatdemo.databinding.FragmentNewChatBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewChatFragment : DemoFragment<FragmentNewChatBinding>() {

    private val viewModel: NewChatViewModel by viewModels()
    override fun binding(inflater: LayoutInflater, container: ViewGroup?): FragmentNewChatBinding {
        return FragmentNewChatBinding.inflate(inflater, container, false)
    }

    override fun render(state: State) {
        when (state as NewChatViewState) {
            NewChatViewState.ChatExist -> {
                showWarning()
            }

            NewChatViewState.IdleState -> {

            }

            NewChatViewState.Success -> {
                findNavController().popBackStack()
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
            btnNew.setOnClickListener {
                viewModel.createNewChat(etName.text.toString())
            }
        }
    }

    private fun showWarning() {
        Snackbar.make(viewBinding.clRoot, getString(R.string.exist_warning), Snackbar.LENGTH_LONG)
            .show()
    }
}