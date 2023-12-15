package com.example.genshinassistant.models

data class SkillTalent(
    val description: String? = "",
    val name: String? = "",
    val type: String? = "",
    val unlock: String? = "",
    val upgrades: List<Upgrade>?
)