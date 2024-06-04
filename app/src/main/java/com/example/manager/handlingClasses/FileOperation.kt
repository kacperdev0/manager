package com.example.manager.handlingClasses

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException

class FileOperation(val dir: String, val context: Context) {
    var SingleEntries = mutableListOf<SingleEntry>()

    fun loadData() {
        val file = File(context.filesDir, dir + ".json")

        try {
            val data = file.readText()
            if (!data.isEmpty()) {
                SingleEntries = Json.decodeFromString(data)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun saveData() {
        try {
            this.context.openFileOutput(dir + ".json", Context.MODE_PRIVATE).use { file ->
                file.write(Json.encodeToString(SingleEntries).toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun addSingleEntry(data: String, mood_id: Int) {
        SingleEntries.add(SingleEntry(data, mood_id))
        saveData()
    }
    fun deleteSingleEntry(index: Int) {
        if (index == -1) { return }

        SingleEntries.removeAt(index)
        saveData()
    }
    fun getAllEntries(): List<SingleEntry> {
        return SingleEntries
    }
}