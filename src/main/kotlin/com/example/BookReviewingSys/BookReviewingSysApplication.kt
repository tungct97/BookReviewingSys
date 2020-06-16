package com.example.BookReviewingSys

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BookReviewingSysApplication

fun main(args: Array<String>) {
	runApplication<BookReviewingSysApplication>(*args)
}
