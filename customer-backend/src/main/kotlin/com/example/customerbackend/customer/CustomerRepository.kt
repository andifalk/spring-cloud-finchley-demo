package com.example.customerbackend.customer

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

interface CustomerRepository : ReactiveMongoRepository<CustomerDocument, String> {

    fun findAllByLastName(lastName: String): Flux<CustomerDocument>

    fun findOneByIdentifier(identifier: UUID): Mono<CustomerDocument>

}
