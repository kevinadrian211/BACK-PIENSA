package com.example.piensaback.controller

import com.example.piensaback.entity.Records
import com.example.piensaback.service.RecordsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
class RecordsController {

    @Autowired
    lateinit var recordsService: RecordsService

    @GetMapping
    fun list(): List<Records> {
        return recordsService.getAllRecords()
    }

    @PostMapping
    fun save(@RequestBody records: Records): Records {
        return recordsService.createRecord(records)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody records: Records): ResponseEntity<Records> {
        val updatedRecord = recordsService.updateRecord(records)
        return ResponseEntity(updatedRecord, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        recordsService.deleteRecord(id)
        return ResponseEntity.ok("Record deleted successfully")
    }
}