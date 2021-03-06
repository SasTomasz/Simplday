package com.example.android.simplday.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @param taskId is ID of task
 * @param taskName is Title of task
 * @param taskPriority is priority of tasks (A, B, C or D)
 */
@Entity(tableName = "tasks_table")
data class TaskForDatabase(
    @PrimaryKey(autoGenerate = true)
    val taskId: Long = 0L,

    @ColumnInfo(name = "task_name")
    val taskName: String?,

    @ColumnInfo(name = "task_priority")
    val taskPriority: String?
)