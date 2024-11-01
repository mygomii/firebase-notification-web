package com.mygomii.firebasenotificationweb.data.repository

import com.mygomii.firebasenotificationweb.data.entities.Token
import org.springframework.data.repository.CrudRepository

interface TokenRepository : CrudRepository<Token, Long> {
    fun findByDeviceId(deviceId: String): Token?
}