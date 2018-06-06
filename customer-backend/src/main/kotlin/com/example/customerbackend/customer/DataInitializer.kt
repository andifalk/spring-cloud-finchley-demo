package com.example.customerbackend.customer

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class DataInitializer(val customerRepository: CustomerRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        listOf(
                CustomerDocument("1111", UUID.randomUUID(), "Max", "Muster"),
                CustomerDocument("2222", UUID.randomUUID(), "Hans", "Huber"),
                CustomerDocument("3333", UUID.randomUUID(), "Steffi", "Baum")
        ).forEach { customerRepository.save(it).subscribe() }
    }

}
