package com.example.android.simplday

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.android.simplday.database.TaskForDatabase

/**
 * It creates string
 * @param tasks is List of Tasks from database
 * @return text for TextView to my tests purposes before I'll create RecyclerView
 */
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

// todo clean code, add comments at least to all methods in all classes -> try to do this every
//  time you create new method or classes

// todo in free moment see more about spanned at
//  https://stackoverflow.com/questions/17546955/android-spanned-spannedstring-spannable-spannablestring-and-charsequence