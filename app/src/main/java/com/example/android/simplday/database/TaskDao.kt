package com.example.android.simplday.database

import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: TaskForDatabase)

    @Update
    fun updateTask(task: TaskForDatabase)

    @Delete
    fun deleteTask(task: TaskForDatabase)

    @Query("SELECT * FROM tasks_table WHERE taskId = :key")
    fun getTask(key: Long): TaskForDatabase

}