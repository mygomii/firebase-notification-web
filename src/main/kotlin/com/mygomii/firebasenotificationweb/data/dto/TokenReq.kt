package com.mygomii.firebasenotificationweb.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TokenReq(
    val token: String,
    val deviceId: String,
)