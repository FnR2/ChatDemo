package com.bedir.chatdemo

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object ChatListModule{

    @FragmentScoped
    @Provides
    fun provideProductAdapter(eventListener: EventListener): ChatListAdapter {
        return ChatListAdapter(eventListener)
    }

}