package com.example.bookbackend.book

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val bookRepository: BookRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        listOf(
                Book("Clean Code", "11111"),
                Book("Cloud Native Java", "2222"),
                Book("Agile Testing", "3333")
        ).forEach { bookRepository.save(it) }
    }

}
