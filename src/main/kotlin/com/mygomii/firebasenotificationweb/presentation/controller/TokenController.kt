package com.mygomii.firebasenotificationweb.presentation.controller

import com.mygomii.firebasenotificationweb.data.dto.TokenReq
import com.mygomii.firebasenotificationweb.data.dto.TokenRes
import com.mygomii.firebasenotificationweb.data.entities.Token
import com.mygomii.firebasenotificationweb.data.services.TokenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TokenController(
    private val tokenService: TokenService,
    private val fcmTokenService: TokenService
) {

    @GetMapping("/firebase/token")
    fun getToken(): String {
        val accessToken = fcmTokenService.getAccessToken()
        println("Access Token: $accessToken")
        return accessToken
    }

    @PostMapping("/token")
    fun insertToken(@RequestBody request: TokenReq): TokenRes {
        println("###### token ${request.token}")
        println("###### deviceId ${request.deviceId}")
        val tokenDevice = Token(
            token = request.token,
            deviceId = request.deviceId
        )

        val isSuccess = request.token.isNotBlank()
        if (isSuccess) {
            tokenService.saveOrUpdateTokenDevice(tokenDevice)
        }

        return TokenRes(isSuccess = isSuccess, token = request.token)
    }
}