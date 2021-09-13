package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.UserDto
import com.ats.atsbookmyshow.domain.User
import com.ats.atsbookmyshow.repository.UserRepository
import com.ats.atsbookmyshow.service.UserService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.function.Function
import java.util.stream.Collectors

@RestController
@CrossOrigin
@RequestMapping("/users")
class UserController(
        var userService: UserService
        ) {

    /*@Autowired
    lateinit var userRepository: UserRepository*/

    @GetMapping(value = [""])
    fun getUsers(): Flux<User> {
        return userService.getUsers()
    }

    @GetMapping(value = ["/get"])
    fun getUsersGet(): Flux<UserDto> {
        return userService.getUsers().map {user ->  userService.convertToUserDto(user) }
    }

    @GetMapping(value = ["/{sex}"])
    fun getUsersBySex(@PathVariable("sex") sex: String): Flux<UserDto> {
        return userService.getUsersBySex(sex)
    }

    @PostMapping("")
    fun createUser(@RequestBody userMono: Mono<User>): Mono<UserDto> {
        return userService.createUser(userMono)
    }
}