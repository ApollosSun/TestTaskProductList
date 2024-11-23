package com.dowell.testtaskproductlist.core.data.util

import android.content.Context

object RawResourceReader {
    fun readJsonFromRaw(context: Context, resourceId: Int): String {
        val inputStream = context.resources.openRawResource(resourceId)
        return inputStream.bufferedReader().use { it.readText() }
    }
}