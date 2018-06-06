package com.example.bookbackend.book

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.Entity

@Entity
class Book(var title: String, var isbn: String) : AbstractPersistable<Long>() {

    constructor() : this("", "")

}