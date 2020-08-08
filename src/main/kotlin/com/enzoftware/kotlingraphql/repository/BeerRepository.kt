package com.enzoftware.kotlingraphql.repository

import com.enzoftware.kotlingraphql.model.Beer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BeerRepository: MongoRepository<Beer, String>