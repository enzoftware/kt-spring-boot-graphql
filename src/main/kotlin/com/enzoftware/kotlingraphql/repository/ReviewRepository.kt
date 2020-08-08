package com.enzoftware.kotlingraphql.repository

import com.enzoftware.kotlingraphql.model.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : MongoRepository<Review, String>