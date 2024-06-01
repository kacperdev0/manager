package com.example.manager.handlingClasses

class FileOperation(val dir: String) {
    var SingleEntries = mutableListOf<SingleEntry>()
    fun saveSingleEntry(data: java.util.Date, mood: SingleMood) {
        SingleEntries.add(SingleEntry(data, mood))
    }
    fun getAllEntries(): List<SingleEntry> {
        return SingleEntries
    }
}