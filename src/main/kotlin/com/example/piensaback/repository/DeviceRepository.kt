package com.example.piensaback.repository

import com.example.piensaback.entity.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : JpaRepository<Device, Long> {
    fun findById(id: Long?): Device?
}