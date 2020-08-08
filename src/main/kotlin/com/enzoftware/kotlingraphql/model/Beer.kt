package com.enzoftware.kotlingraphql.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "beers")
data class Beer(val name: String, var amount: Float) {
    @Id
    var id: String = ""

    @Transient
    var reviews: List<Review> = ArrayList()
}