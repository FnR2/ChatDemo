package com.bedir.chatdemo

import com.bedir.data.DefaultChatDao
import com.bedir.room.ChatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideChatDaoProvider(chatDao: ChatDao): DefaultChatDao {
        return ChatDaoProvider(chatDao)
    }


}