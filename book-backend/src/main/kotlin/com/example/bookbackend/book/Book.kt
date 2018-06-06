package com.example.bookbackend.book

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.Entity

@Entity
class Book(val title: String, val isbn: String) : AbstractPersistable<Long>() {

    constructor() : this("", "") {
    }

}