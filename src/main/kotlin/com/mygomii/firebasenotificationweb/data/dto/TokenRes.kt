package com.mygomii.firebasenotificationweb.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TokenRes(
    val isSuccess: Boolean,
    val token: String? = null,
)