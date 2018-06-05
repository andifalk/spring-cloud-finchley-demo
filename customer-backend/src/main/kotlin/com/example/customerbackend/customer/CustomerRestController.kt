package com.example.customerbackend.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerRestController(@Autowired val customerRepository: CustomerRepository) {

    @GetMapping
    fun findAllCustomers() = customerRepository.findAll()

}
