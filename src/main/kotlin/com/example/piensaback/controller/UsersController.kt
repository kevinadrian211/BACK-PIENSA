package com.example.piensaback.controller

import com.example.piensaback.entity.Users
import com.example.piensaback.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun list(): List<Users> {
        return usersService.getAllUsers()
    }

    @PostMapping
    fun save(@RequestBody users: Users): Users {
        return usersService.createUser(users)
    }

    @PutMapping
    fun update(@RequestBody users: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.updateUser(users), HttpStatus.OK)
    }

    @PatchMapping("/{id}")
    fun updateRole(@PathVariable id: Long, @RequestParam role: String): ResponseEntity<Users> {
        val updatedUser = usersService.updateUserRole(id, role)
        return ResponseEntity(updatedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        usersService.deleteUser(id)
        return ResponseEntity.ok("User deleted successfully")
    }
}