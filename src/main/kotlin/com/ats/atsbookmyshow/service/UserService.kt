package com.ats.atsbookmyshow.service

import com.ats.atsbookmyshow.UserDto
import com.ats.atsbookmyshow.domain.User
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {
    fun getUsers(): Flux<User>
    fun getUsersBySex(sex: String): Flux<UserDto>
    fun createUser(user: Mono<User>): Mono<UserDto>
    fun convertToUserDto(user: User): UserDto
}