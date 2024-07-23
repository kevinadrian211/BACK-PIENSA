package com.example.piensaback.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "records")
class Records {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    var device: Device? = null

    var times: LocalDateTime? = null
    var timevalues: Double?= null
}