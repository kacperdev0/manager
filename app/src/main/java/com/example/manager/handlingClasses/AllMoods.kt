package com.example.manager.handlingClasses

class AllMoods(val dir: String) {
    val moods = mutableListOf<SingleMood>(SingleMood(1, "Happy", 90), SingleMood(2, "Meh", 50), SingleMood(3, "Sad", 20))

    fun arrayOfMoods(): Array<String> {
        return moods.map{it.name}.toTypedArray()
    }
}