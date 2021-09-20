package com.ats.atsbookmyshow.repository

import com.ats.atsbookmyshow.domain.CategoryAttribute
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryAttributesRepository: ReactiveMongoRepository<CategoryAttribute, String> {
}