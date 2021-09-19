package com.ats.atsbookmyshow.repository

import com.ats.atsbookmyshow.domain.CategoryAttributes
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryAttributesRepository: ReactiveMongoRepository<CategoryAttributes, String> {
}