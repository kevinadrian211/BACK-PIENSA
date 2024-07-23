package com.example.piensaback.repository

import com.example.piensaback.entity.Records
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordsRepository : JpaRepository<Records, Long> {
    fun findById(id: Long?): Records?
}