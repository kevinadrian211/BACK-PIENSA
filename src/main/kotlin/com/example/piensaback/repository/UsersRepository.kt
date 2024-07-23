package com.example.piensaback.repository

import com.example.piensaback.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Users, Long> {
    fun findById(id: Long?): Users?
}