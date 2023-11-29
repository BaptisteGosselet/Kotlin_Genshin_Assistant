package com.example.genshinassistant.models

data class PassiveTalent(
    val description: String,
    val level: Int = 0,
    val name: String,
    val unlock: String
)