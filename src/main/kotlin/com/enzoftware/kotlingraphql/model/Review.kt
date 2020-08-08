package com.enzoftware.kotlingraphql.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class Review(val beerId: String, var text: String)