package com.enzoftware.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.enzoftware.kotlingraphql.model.Review
import com.enzoftware.kotlingraphql.repository.ReviewRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver(val reviewRepository: ReviewRepository, val mongoOperations: MongoOperations) : GraphQLMutationResolver {

    fun addReview(beer: String, text: String): Review {
        val review = Review(beer, text)
        reviewRepository.insert(review)
        return review
    }
}