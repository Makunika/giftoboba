package ru.pshiblo.giftoboba

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import kotlinx.serialization.json.Json
import ru.pshiblo.giftoboba.config.Config
import java.io.File

fun main(args: Array<String>) {
    val json = Json { ignoreUnknownKeys = true }
    val config: Config = json.decodeFromString(Config.serializer(), File(args.first()).readText())

    val bot = bot {
        token = config.tgToken
        dispatch {
            command("start") {

            }
        }
    }
    bot.startPolling()
}