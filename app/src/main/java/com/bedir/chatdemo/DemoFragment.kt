package com.bedir.chatdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class DemoFragment<VB : ViewBinding>() : Fragment(), EventPublisher {

    private var mBinding: VB? = null
    val viewBinding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = binding(inflater, container)
        return mBinding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    abstract fun binding(
        inflater: LayoutInflater, container: ViewGroup?
    ): VB

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    fun subscribeFlow(stateHolder: MutableStateFlow<State>) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                stateHolder.collect {
                    render(it)

                }
            }
        }
    }

    abstract fun render(state: State)

    fun subscribeEvents(events: Flow<Event>) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                events.collect {
                    handleEvent(it)
                }
            }

        }
    }

    abstract fun handleEvent(event: Event)
    override fun sendEvent(event: Event) {
        handleEvent(event)
    }

}