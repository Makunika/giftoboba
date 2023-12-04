package ru.pshiblo.bot.wishlist.config

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val token: String
)