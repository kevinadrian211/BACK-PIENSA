package com.example.piensaback.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var username: String? = null
    var password: String? = null
    var nameu: String? = null
    var email: String? = null
    var roleu: String? = null
}