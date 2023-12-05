package ru.pshiblo.giftoboba.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.asJdbcDriver
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import ru.pshiblo.giftoboba.config.Config

class DatabaseFactory(
    private val config: Config
) {
    fun createDatabase(): Database = Database(
        driver = createDriver()
    )

    private fun createDriver(): SqlDriver {
        val hikariConfig = HikariConfig()
        hikariConfig.driverClassName = "org.postgresql.Driver"
        hikariConfig.password = config.dbPassword
        hikariConfig.username = config.dbUser
        hikariConfig.jdbcUrl = config.dbUrl
        return HikariDataSource(hikariConfig).asJdbcDriver()
    }
}