package com.bedir.chatdemo

import com.bedir.data.ChatRepository
import com.bedir.usecase.GetAllChatUseCase
import com.bedir.usecase.GetChatMessagesUseCase
import com.bedir.usecase.SendMessageUseCase
import com.bedir.usecase.StartChatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ChatListViewModelModule {


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

    @ViewModelScoped
    @Provides
    fun provideGetMessagesUseCase(repository: ChatRepository): GetChatMessagesUseCase {
        return GetChatMessagesUseCase(repository)
    }


}

@Module
@InstallIn(FragmentComponent::class)
object ChatListFragmentModule {
    @FragmentScoped
    @Provides
    fun provideChatListAdapter(eventPublisher: EventPublisher): ChatListAdapter {
        return ChatListAdapter(eventPublisher)
    }

    @FragmentScoped
    @Provides
    fun provideMessagingAdapter(eventPublisher: EventPublisher): MessagingAdapter {
        return MessagingAdapter(eventPublisher)
    }
}