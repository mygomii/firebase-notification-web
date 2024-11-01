package com.mygomii.firebasenotificationweb.data.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "token")
data class Token(
    @Id
    val id: Long? = null,
    val token: String,
    val deviceId: String
)