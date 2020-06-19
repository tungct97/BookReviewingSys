package com.example.BookReviewingSys.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        var password: String? = null,
        val username: String? = null,
        @Column(name = "first_name")
        val firstName: String? = null,
        @Column(name = "last_name")
        val lastName: String? = null,
        val email: String? = null,
        @JsonIgnore
        val role: String? = "USER"
) : DateAudit() {

    companion object {
        private const val serialVersionUID = 1L
    }
}

