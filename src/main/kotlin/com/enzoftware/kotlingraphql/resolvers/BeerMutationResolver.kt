package com.enzoftware.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.enzoftware.kotlingraphql.model.Beer
import com.enzoftware.kotlingraphql.repository.BeerRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class BeerMutationResolver(val beerRepository: BeerRepository) : GraphQLMutationResolver {

    fun addBeer(name: String, amount: Float): Beer {
        val beer = Beer(name, amount)
        beer.id = UUID.randomUUID().toString()
        beerRepository.insert(beer)
        return beer
    }

    fun deleteBeer(beer: String): Boolean {
        beerRepository.deleteById(beer)
        return true
    }

    fun updateBeer(beerId: String, amount: Float): Beer {
        val beer = beerRepository.findById(beerId)
        beer.ifPresent {
            it.amount = amount
            beerRepository.save(it)
        }
        return beer.get()
    }
}