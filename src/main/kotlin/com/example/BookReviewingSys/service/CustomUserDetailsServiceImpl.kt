package com.example.BookReviewingSys.service

import com.example.BookReviewingSys.model.CustomUserDetails
import com.example.BookReviewingSys.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
open class CustomUserDetailsServiceImpl : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findUserByUsername(username).orElseThrow { UsernameNotFoundException(username) }
        return CustomUserDetails.create(user)
    }

    fun loadUserById(id: Long): CustomUserDetails {
        val user = userRepository.findById(id).orElseThrow { UsernameNotFoundException("User not found with id : $id") }
        return CustomUserDetails.create(user)
    }
}