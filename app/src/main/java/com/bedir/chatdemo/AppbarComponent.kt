package com.bedir.chatdemo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.bedir.chatdemo.databinding.CustomAppBarBinding
import com.google.android.material.appbar.AppBarLayout


class AppbarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    AppBarLayout(context, attrs, defStyleAttr) {

    private var appBarBinding: CustomAppBarBinding =
        CustomAppBarBinding.inflate(LayoutInflater.from(context), this, true)

    private var eventPublisher: EventPublisher? = null
    fun setTitle(title: String) {
        appBarBinding.tvTitle.text = title
    }

    fun setEventPublisher(eventPublisher: EventPublisher) {
        this.eventPublisher = eventPublisher
    }

    init {
        appBarBinding.ivMute.setOnClickListener {
            eventPublisher?.sendEvent(ChatMuteEvent)
        }

        appBarBinding.ivDelete.setOnClickListener {
            eventPublisher?.sendEvent(ChatDeleteEvent)
        }
    }

    fun switchIcons() {
        with(appBarBinding) {
            ivMute.visibility = if (ivMute.isVisible) {
                View.GONE
            } else {
                View.VISIBLE
            }

            ivDelete.visibility = if (ivDelete.isVisible) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }


}
