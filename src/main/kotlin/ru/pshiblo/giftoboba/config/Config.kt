package ru.pshiblo.giftoboba.config

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val tgToken: String,
    val dbUrl: String,
    val dbPassword: String,
    val dbUser: String
)