package com.bedir.chatdemo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
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


}
