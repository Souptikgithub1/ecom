package com.ats.atsbookmyshow.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductService {
    fun save(productMap: MutableMap<String, Any>): Mono<MutableMap<String, Any>>
    fun findAll(): Flux<MutableMap<String, Any>>
    fun findById(id: String): Mono<MutableMap<String, Any>>
    fun find6Products(): Flux<MutableMap<String, Any>>
}