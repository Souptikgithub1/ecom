package com.ats.atsbookmyshow.repository

import com.ats.atsbookmyshow.domain.Attribute
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface AttributeRepository: ReactiveMongoRepository<Attribute, String> {
    fun findByAttributeIdIn(ids: List<String?>?): Flux<Attribute>
}