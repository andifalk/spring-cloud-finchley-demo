package com.example.customerbackend.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class CustomerDocument(
        @Id val id: String, val identifier: UUID, val firstName: String,
        @Indexed val lastName: String)