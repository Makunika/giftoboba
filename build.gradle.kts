plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("app.cash.sqldelight") version "2.0.1"
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    application
}

group = "ru.pshiblo.giftoboba"
version = "1.0-SNAPSHOT"

val koinVersion = "3.5.0"
val koinKspVersion = "1.3.0"
val ktLogVersion = "5.1.0"
val kotlinxVersion = "1.6.0"
val tgBotVersion = "6.1.0"
val hikariVersion = "5.0.1"
val postgresVersion = "42.6.0"
val sl4jVersion = "2.0.7"

repositories {
    mavenCentral()
    google()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    maven(url = "https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.slf4j:slf4j-simple:$sl4jVersion")
    implementation("org.slf4j:slf4j-api:$sl4jVersion")
    implementation("io.github.oshai:kotlin-logging-jvm:$ktLogVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxVersion")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:$tgBotVersion")
    implementation("com.zaxxer:HikariCP:$hikariVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("io.insert-koin:koin-annotations-bom:$koinKspVersion")

    runtimeOnly("io.insert-koin:koin-core:$koinVersion")
    runtimeOnly("io.insert-koin:koin-annotations:$koinKspVersion")
    ksp("io.insert-koin:koin-ksp-compiler:$koinKspVersion")

    implementation("app.cash.sqldelight:jdbc-driver:2.0.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("ru.pshiblo.giftoboba.MainKt")
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("ru.pshiblo.giftoboba.db")
            dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
        }
    }
}