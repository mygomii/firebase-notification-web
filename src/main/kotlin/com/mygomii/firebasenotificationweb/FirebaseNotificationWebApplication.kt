package com.mygomii.firebasenotificationweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories(basePackages = ["com.mygomii.firebasenotificationweb.data.repository"])
class FirebaseNotificationWebApplication

fun main(args: Array<String>) {
    runApplication<FirebaseNotificationWebApplication>(*args)
}
