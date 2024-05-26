package com.example.manager.handlingClasses

class AllMoods(val dir: String) {
    val moods = mutableListOf<SingleMood>(SingleMood(1, "Happy"), SingleMood(2, "Meh"), SingleMood(3, "Sad"))

    fun arrayOfMoods(): Array<String> {
        return moods.map{it.name}.toTypedArray()
    }
}