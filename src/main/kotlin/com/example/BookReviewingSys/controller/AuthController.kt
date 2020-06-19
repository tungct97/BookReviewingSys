package com.example.BookReviewingSys.controller

import com.example.BookReviewingSys.model.User
import com.example.BookReviewingSys.payload.AuthRequest
import com.example.BookReviewingSys.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController {
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @PostMapping("/signup")
    fun registerUser(@RequestBody authRequest: AuthRequest): ResponseEntity<HttpStatus> {
        if (userRepository.existsUserByUsername(authRequest.username)) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val user = User(username = authRequest.username, password = authRequest.password)

        user.password = passwordEncoder.encode(user.password)

        userRepository.save(user)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/signin")
    fun loginUser(): String = "a"
}