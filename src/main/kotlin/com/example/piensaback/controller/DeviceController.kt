package com.example.piensaback.controller

import com.example.piensaback.entity.Device
import com.example.piensaback.service.DeviceService
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
@RequestMapping("/device")
class DeviceController {

    @Autowired
    lateinit var deviceService: DeviceService

    @GetMapping
    fun list(): List<Device> {
        return deviceService.getAllDevices()
    }

    @PostMapping
    fun save(@RequestBody device: Device): Device {
        return deviceService.createDevice(device)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody device: Device): ResponseEntity<Device> {
        val updatedDevice = deviceService.updateDevice(device)
        return ResponseEntity(updatedDevice, HttpStatus.OK)
    }

    @PatchMapping("/{id}/ontime")
    fun updateOnTime(@PathVariable id: Long, @RequestParam newOnTime: Boolean): ResponseEntity<Device> {
        val updatedDevice = deviceService.updateDeviceOnTime(id, newOnTime)
        return ResponseEntity(updatedDevice, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        deviceService.deleteDevice(id)
        return ResponseEntity.ok("Device deleted successfully")
    }
}