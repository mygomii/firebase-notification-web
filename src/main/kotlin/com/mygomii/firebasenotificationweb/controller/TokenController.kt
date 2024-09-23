package com.mygomii.firebasenotificationweb.controller

import com.mygomii.firebasenotificationweb.data.models.TokenReq
import com.mygomii.firebasenotificationweb.data.models.TokenRes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TokenController {
    @PostMapping("/token")
    fun insertToken(@RequestBody tokenReq: TokenReq): TokenRes {
        println("token : ${tokenReq.token}")
        val isSuccess = tokenReq.token.isNotBlank()
        return TokenRes(isSuccess = isSuccess, token = tokenReq.token)
    }
}