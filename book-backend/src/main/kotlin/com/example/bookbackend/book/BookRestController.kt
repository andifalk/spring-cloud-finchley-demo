package com.example.bookbackend.book

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookRestController(val bookRepository: BookRepository) {

    @GetMapping
    fun findAllBooks(): List<Book> = bookRepository.findAll()
}
