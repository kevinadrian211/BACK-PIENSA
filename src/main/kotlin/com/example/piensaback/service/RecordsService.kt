package com.example.piensaback.service

import com.example.piensaback.entity.Records
import com.example.piensaback.repository.RecordsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class RecordsService {

    @Autowired
    lateinit var recordsRepository: RecordsRepository

    fun getAllRecords(): List<Records> {
        return recordsRepository.findAll()
    }

    fun getRecordById(id: Long): Records {
        return recordsRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found") }
    }

    fun createRecord(records: Records): Records {
        // Set current timestamp if not provided
        if (records.times == null) {
            records.times = LocalDateTime.now()
        }
        return recordsRepository.save(records)
    }

    fun updateRecord(records: Records): Records {
        if (!recordsRepository.existsById(records.id!!)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found")
        }
        return recordsRepository.save(records)
    }

    fun updateRecordTimeValues(id: Long, newTimeValues: Double): Records {
        val record = recordsRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found") }
        record.timevalues = newTimeValues
        return recordsRepository.save(record)
    }

    fun deleteRecord(id: Long) {
        val record = recordsRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found") }
        recordsRepository.delete(record)
    }
}