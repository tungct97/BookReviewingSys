package com.example.BookReviewingSys.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class CustomUserDetails(
        val id: Long? = null,
        private val username: String,
        private val password: String,
        private val authorities: Collection<GrantedAuthority>
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    companion object {
        fun create(user: User): CustomUserDetails {
            val authorities: MutableList<SimpleGrantedAuthority>? = Collections.singletonList(SimpleGrantedAuthority(user.role));
            return CustomUserDetails(user.id, user.username ?: "", user.password ?: "", authorities ?: mutableListOf())
        }
    }
}