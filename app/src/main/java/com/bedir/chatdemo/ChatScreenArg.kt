package com.bedir.chatdemo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatScreenArg(val id: String, val name: String) : Parcelable
