plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("app.cash.sqldelight") version "2.0.1"
    application
}

group = "ru.pshiblo.bot.wishlist"
version = "1.0-SNAPSHOT"

var koinVersion = "3.5.0"
var ksLogVersion = "1.3.1"
var kotlinxVersion = "1.6.0"
var tgBotVersion = "6.1.0"

repositories {
    mavenCentral()
    google()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    maven(url = "https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("dev.inmo:kslog:$ksLogVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxVersion")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:$tgBotVersion")

    runtimeOnly("io.insert-koin:koin-core:$koinVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("ru.pshiblo.bot.wishlist.db")
            dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
        }
    }
}