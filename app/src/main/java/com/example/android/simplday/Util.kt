package com.example.android.simplday

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.android.simplday.database.TaskForDatabase

fun stringListOfTasks(tasks: List<TaskForDatabase>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        tasks.forEach {
            append("${it.taskName} <br>")
            append("${it.taskPriority} <br>")
            append("<br>")
        }

    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

// todo clean code, add comments at least to all methods in all classes