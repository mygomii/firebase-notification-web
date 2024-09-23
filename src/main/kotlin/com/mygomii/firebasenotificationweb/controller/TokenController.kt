package com.mygomii.firebasenotificationweb.controller

import com.mygomii.firebasenotificationweb.data.models.TokenRes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TokenController {
    @PostMapping("/token")
    fun insertToken(@RequestBody tokenRes: TokenRes): TokenRes {
        println("token : ${tokenRes.token}")
        val isSuccess = tokenRes.token?.isNotBlank() ?: false
        return TokenRes(isSuccess = isSuccess, token = tokenRes.token)
    }
}