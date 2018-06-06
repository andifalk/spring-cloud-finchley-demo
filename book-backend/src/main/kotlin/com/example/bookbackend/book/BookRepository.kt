package com.example.bookbackend.book

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findOneByIsbn(isbn: String)
}
