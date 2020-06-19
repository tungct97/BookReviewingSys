package com.example.BookReviewingSys.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties(value = ["created_at", "updated_at"], allowGetters = true)
abstract class DateAudit : Serializable {
    @CreatedDate
    @JsonIgnore
    @Column(nullable = false, updatable = false, name = "created_at")
    var createdAt: Instant? = null

    @LastModifiedDate
    @JsonIgnore
    @Column(nullable = false, name = "updated_at")
    var updatedAt: Instant? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}