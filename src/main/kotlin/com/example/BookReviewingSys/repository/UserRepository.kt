package com.example.BookReviewingSys.repository

import com.example.BookReviewingSys.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findUserByUsername(userName: String?): Optional<User>

    fun existsUserByUsername(username: String?): Boolean
}