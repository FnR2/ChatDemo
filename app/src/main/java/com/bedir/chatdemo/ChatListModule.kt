package com.bedir.chatdemo

import android.content.Context
import com.bedir.data.ChatRepository
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.SendMessageUseCase
import com.bedir.usecase.StartChatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ChatListViewModelModule{


    @ViewModelScoped
    @Provides
    fun provideSendMessageUseCase(repository: ChatRepository): SendMessageUseCase {
        return SendMessageUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetAllChatUseCase(repository: ChatRepository): GetAllChatUseCase {
        return GetAllChatUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideNewChatUseCase(repository: ChatRepository): StartChatUseCase {
        return StartChatUseCase(repository)
    }




}
@Module
@InstallIn(FragmentComponent::class)
object ChatListFragmentModule{
    @FragmentScoped
    @Provides
    fun provideProductAdapter(eventListener: EventListener): ChatListAdapter {
        return ChatListAdapter(eventListener)
    }
}