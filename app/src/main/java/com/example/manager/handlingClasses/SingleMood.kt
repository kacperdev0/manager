package com.example.manager.handlingClasses

import kotlinx.serialization.Serializable


@Serializable
data class SingleMood(val id: Int = 0, val name: String = "TestValue", val vibe: Int = 50) {

}