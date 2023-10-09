package com.bedir.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bedir.entity.Chat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
class ChatDaoTest {
    private lateinit var roomDb: ConversationDB
    private lateinit var chatDao: ChatDao

    @Before
    fun setupDatabase() {
        roomDb = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ConversationDB::class.java
        ).allowMainThreadQueries().build()

        chatDao = roomDb.getConversationDao()
    }

    @After
    fun closeDatabase() {
        roomDb.close()
    }

    @Test
    fun insertChat_success() = runBlocking {
        val sample = Chat(name = "Friend", isMuted = false)
        chatDao.insertChat(sample)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            chatDao.getAllChats().collect {
                val isExist = it.firstOrNull {
                    it.chat.name == sample.name
                } != null
                assertTrue(isExist)
                latch.countDown()

            }
        }
        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun getAllChat_success() = runBlocking {
        val friend = Chat(name = "Friend", isMuted = false)
        val buddy = Chat(name = "Buddy", isMuted = false)
        val bro = Chat(name = "Bro", isMuted = false)
        chatDao.insertChat(friend)
        chatDao.insertChat(buddy)
        chatDao.insertChat(bro)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            chatDao.getAllChats().collect {
                assertEquals(3,it.size)
                latch.countDown()

            }
        }
        latch.await()
        job.cancelAndJoin()
    }
}