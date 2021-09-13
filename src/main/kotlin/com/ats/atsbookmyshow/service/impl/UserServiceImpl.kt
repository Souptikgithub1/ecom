package com.ats.atsbookmyshow.service.impl

import com.ats.atsbookmyshow.UserDto
import com.ats.atsbookmyshow.domain.User
import com.ats.atsbookmyshow.repository.UserRepository
import com.ats.atsbookmyshow.service.UserService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Service
class UserServiceImpl(var userRepository: UserRepository
                        ): UserService{

    override fun getUsers(): Flux<User> {
        return userRepository.findAll().delayElements(Duration.ofSeconds(1))
    }

    override fun getUsersBySex(sex: String): Flux<UserDto> {
        return userRepository.findBySex(sex.toUpperCase()).map { user -> convertToUserDto(user) }
    }


    override fun convertToUserDto(user: User): UserDto {
        val userDto: UserDto = jacksonObjectMapper().convertValue(user, object: TypeReference<UserDto>() {})
        userDto.dateOfBirth = LocalDateTime.ofInstant(Instant.ofEpochMilli(user.dateOfBirth), ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        return userDto
    }

    override fun createUser(user: Mono<User>): Mono<UserDto> {
        return  user.flatMap { userRepository.save(it) }
                        .map { convertToUserDto(it) }
    }
}