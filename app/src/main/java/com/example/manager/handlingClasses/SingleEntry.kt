package com.example.manager.handlingClasses

import kotlinx.serialization.Serializable
import java.util.Date


@Serializable
class SingleEntry(val date: String, val mood_id: Int) {
    fun printEntryData() {
        println(date.toString() + mood_id.toString())
    }

    fun getEntryData(): String  {
        return date.toString() + "id of mood: " + mood_id.toString()
    }
}