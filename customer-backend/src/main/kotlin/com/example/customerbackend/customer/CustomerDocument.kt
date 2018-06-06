package com.example.customerbackend.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class CustomerDocument(
        @Id var id: String, var identifier: UUID, var firstName: String,
        @Indexed var lastName: String)