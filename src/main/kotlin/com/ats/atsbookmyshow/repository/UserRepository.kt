package com.ats.atsbookmyshow.repository

import com.ats.atsbookmyshow.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface UserRepository : ReactiveMongoRepository<User, String> {
    fun findBySex(sex: String): Flux<User>
}