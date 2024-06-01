package com.example.manager.handlingClasses

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException

class AllMoods(val dir: String, val context: Context) {

    var moods = mutableListOf<SingleMood>()

    fun loadData() {
        val file = File(context.filesDir, "$dir.json")
        if (!file.exists() || file.readText().isBlank()) {
            moods = mutableListOf(
                SingleMood(1, "Happy", 90),
                SingleMood(2, "Meh", 50),
                SingleMood(3, "Sad", 20)
            )
            saveData()
        }

        try {
            val data = file.readText()
            moods = Json.decodeFromString(data)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
            moods = mutableListOf(
                SingleMood(1, "Happy", 90),
                SingleMood(2, "Meh", 50),
                SingleMood(3, "Sad", 20)
            )
            saveData()
        }
    }

    fun saveData() {
        try {
            this.context.openFileOutput(dir + ".json", Context.MODE_PRIVATE).use { output ->
                output.write(Json.encodeToString(moods).toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun addMood(mood: SingleMood) {
        moods.add(mood)
        saveData()
    }

    fun deleteMood(index: Int) {
        if (index != -1) {
            moods.removeAt(index)
            saveData()
        }
    }

    fun arrayOfMoods(): Array<String> {
        return moods.map{it.name}.toTypedArray()
    }

    fun nextId(): Int {
        if (moods.isEmpty()) {
            return 1
        }

        return moods.last().id + 1
    }
}