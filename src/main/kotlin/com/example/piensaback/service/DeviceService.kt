package com.example.piensaback.service

import com.example.piensaback.entity.Device
import com.example.piensaback.repository.DeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DeviceService {

    @Autowired
    lateinit var deviceRepository: DeviceRepository

    fun getAllDevices(): List<Device> {
        return deviceRepository.findAll()
    }

    fun getDeviceById(id: Long): Device {
        return deviceRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found") }
    }

    fun createDevice(device: Device): Device {
        return deviceRepository.save(device)
    }

    fun updateDevice(device: Device): Device {
        if (!deviceRepository.existsById(device.id!!)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found")
        }
        return deviceRepository.save(device)
    }

    fun updateDeviceOnTime(id: Long, newOnTime: Boolean): Device {
        val device = deviceRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found") }
        device.ontime = newOnTime
        return deviceRepository.save(device)
    }

    fun deleteDevice(id: Long) {
        val device = deviceRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found") }
        deviceRepository.delete(device)
    }
}