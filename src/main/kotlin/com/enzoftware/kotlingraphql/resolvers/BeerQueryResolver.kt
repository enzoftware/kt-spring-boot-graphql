package com.enzoftware.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.enzoftware.kotlingraphql.model.Beer
import com.enzoftware.kotlingraphql.model.Review
import com.enzoftware.kotlingraphql.repository.BeerRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component


@Component
class BeerQueryResolver(val beerRepository: BeerRepository, val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun beers(): List<Beer> {
        val beers = beerRepository.findAll()
        beers.map {
            it.reviews = getReviews(it.id)
        }
        return beers
    }


    private fun getReviews(beer: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("beerId").`is`(beer))
        return mongoOperations.find(query, Review::class.java)
    }
}