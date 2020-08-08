package com.enzoftware.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.enzoftware.kotlingraphql.model.Review
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ReviewQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun reviews(beerId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("beerId").`is`(beerId))
        return mongoOperations.find(query, Review::class.java)
    }
}