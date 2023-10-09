package com.bedir.chatdemo

import android.content.Context
import androidx.room.Room
import com.bedir.chatdemo.Constants.DB_NAME
import com.bedir.room.ChatDao
import com.bedir.room.ConversationDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideConversationDB(@ApplicationContext context: Context): ConversationDB {
        return Room.databaseBuilder(context, ConversationDB::class.java, DB_NAME)
            .enableMultiInstanceInvalidation()
            .build()
    }

    @Singleton
    @Provides
    fun provideChatDao(appDatabase: ConversationDB): ChatDao {
        return appDatabase.getConversationDao()
    }

}