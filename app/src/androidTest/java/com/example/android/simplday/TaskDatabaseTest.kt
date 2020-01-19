package com.example.android.simplday

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.database.TaskDatabase
import com.example.android.simplday.database.TaskForDatabase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TaskDaoTest {
    private lateinit var taskDao: TaskDao
    private lateinit var db: TaskDatabase


    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, TaskDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        taskDao = db.taskDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertAndGetTask() {
        val task1 = TaskForDatabase(taskName = "Clean room", taskPriority = "B")
        val task2 = TaskForDatabase(taskName = "Wash dishes", taskPriority = "A")

        taskDao.insertTask(task1)
        taskDao.insertTask(task2)

        assertEquals(taskDao.getTask(1),
            TaskForDatabase(1L, "Clean room", "B"))
        assertEquals(taskDao.getTask(2),
            TaskForDatabase(2L, "Wash dishes", "A"))
    }

    @Test
    fun updateAndDelete(){
        var task1 = TaskForDatabase(taskName = "Clean room", taskPriority = "B")

        taskDao.insertTask(task1)

        assertEquals(taskDao.getTask(1), TaskForDatabase(1L, "Clean room", "B"))

        //update
        task1 = TaskForDatabase(1L, "Clean bathroom", "A")
        taskDao.updateTask(task1)

        assertEquals(taskDao.getTask(1L), TaskForDatabase(1L, "Clean bathroom", "A"))

        //delete
        taskDao.deleteTask(task1)
        assertNull(taskDao.getTask(1L))
    }

}

// todo get more knowledge about testing

// todo figure out what for is kotlin kapt and what is annotationProcessors -> without this plugin and room dependency in
//  modul app gradle I could't create database. Figure out why was so
