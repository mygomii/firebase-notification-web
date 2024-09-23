package com.mygomii.firebasenotificationweb.data.models

data class TokenRes(
    val isSuccess: Boolean,
    val token: String? = null,
)