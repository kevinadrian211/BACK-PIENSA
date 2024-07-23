package com.example.piensaback.service

import com.example.piensaback.entity.Users
import com.example.piensaback.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getAllUsers(): List<Users> {
        return usersRepository.findAll()
    }

    fun getUserById(id: Long): Users {
        return usersRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") }
    }

    fun createUser(users: Users): Users {
        return usersRepository.save(users)
    }

    fun updateUser(users: Users): Users {
        if (!usersRepository.existsById(users.id!!)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        }
        return usersRepository.save(users)
    }

    fun updateUserRole(id: Long, role: String): Users {
        val user = usersRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") }
        user.roleu = role
        return usersRepository.save(user)
    }

    fun deleteUser(id: Long) {
        val user = usersRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") }
        usersRepository.delete(user)
    }
}