package com.example.piensaback.entity

import jakarta.persistence.*

@Entity
@Table(name = "device")
class Device {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var named: String? = null
    var stated: Boolean? = null
    var ontime: Boolean? = null
    var offtime: Boolean? = null
}