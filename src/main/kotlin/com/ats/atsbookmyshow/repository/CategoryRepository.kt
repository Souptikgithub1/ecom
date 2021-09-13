package com.ats.atsbookmyshow.repository

import com.ats.atsbookmyshow.domain.Category
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface CategoryRepository : ReactiveMongoRepository<Category, String> {
    fun findByCategoryName(categoryName: String): Mono<Category>
}