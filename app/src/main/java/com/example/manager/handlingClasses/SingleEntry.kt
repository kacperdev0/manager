package com.example.manager.handlingClasses

import kotlinx.serialization.Serializable
import java.util.Date


@Serializable
class SingleEntry(val date: String, val mood: SingleMood) {
    fun printEntryData() {
        println(date.toString() + mood.toString())
    }

    fun getEntryData(): String  {
        return date.toString() + mood.name
    }
}