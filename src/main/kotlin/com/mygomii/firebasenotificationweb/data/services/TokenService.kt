package com.mygomii.firebasenotificationweb.data.services

import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.GoogleCredentials
import com.mygomii.firebasenotificationweb.data.entities.Token
import com.mygomii.firebasenotificationweb.data.repository.TokenRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class TokenService(private val repository: TokenRepository) {
    fun getAccessToken(): String {
        val resource: Resource = ClassPathResource("firebase-admin.json")
        val credentialsStream = resource.inputStream
        val credentials = GoogleCredentials.fromStream(credentialsStream)
            .createScoped(listOf("https://www.googleapis.com/auth/firebase.messaging"))

        val accessToken: AccessToken = credentials.refreshAccessToken()
        return accessToken.tokenValue
    }

    fun saveOrUpdateTokenDevice(tokenDevice: Token): Token {
        return repository.findByDeviceId(tokenDevice.deviceId)?.let {
            val updatedDevice = it.copy(token = tokenDevice.token)
            repository.save(updatedDevice)
        } ?: repository.save(tokenDevice)

    }
}