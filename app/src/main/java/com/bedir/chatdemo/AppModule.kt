package com.bedir.chatdemo

import com.bedir.data.ChatRepository
import com.bedir.data.DefaultChatDao
import com.bedir.room.ChatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideChatDaoProvider(chatDao: ChatDao): DefaultChatDao {
        return ChatDaoProvider(chatDao)
    }

    @Singleton
    @Provides
    fun provideMapper(formatter: DateTimeFormatter): ItemMapper {
        return ItemMapper(formatter)
    }

    @Singleton
    @Provides
    fun provideChatRepository(chatDao: DefaultChatDao): ChatRepository {
        return ChatRepository(chatDao)
    }

    @Singleton
    @Provides
    fun provideTimeFormatter(): DateTimeFormatter {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.getDefault())
            .withZone(ZoneId.systemDefault())
    }


}