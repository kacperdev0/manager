package com.example.manager.handlingClasses

import java.util.Date

class SingleEntry(val date: java.util.Date, val mood: SingleMood) {
    fun printEntryData() {
        println(date.toString() + mood.toString())
    }

    fun getEntryData(): String  {
        return date.toString() + mood.name
    }
}