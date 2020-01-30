package com.example.android.simplday.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: TaskForDatabase)

    @Update
    fun updateTask(task: TaskForDatabase)

    @Delete
    fun deleteTask(task: TaskForDatabase)

    /**
     * @return task with specific id
     */
    @Query("SELECT * FROM tasks_table WHERE taskId = :key")
    fun getTask(key: Long): TaskForDatabase

    /**
     * @return List of tasks from last one to first one
     */
    @Query("SELECT * FROM tasks_table ORDER BY taskId DESC")
    fun getAllTasks(): LiveData<List<TaskForDatabase>>

}