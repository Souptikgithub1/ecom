package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.Attribute
import com.ats.atsbookmyshow.repository.AttributeRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/attributes")
class AttributeController(
    val attributeRepository: AttributeRepository
) {

    @PostMapping
    fun create(@RequestBody attribute: Attribute): Mono<Attribute> = attributeRepository.save(attribute)

    @GetMapping
    fun findAll(): Flux<Attribute> = attributeRepository.findAll()

    @DeleteMapping("/{attributeId}")
    fun deleteById(@PathVariable("attributeId") attributeId: String): Mono<Void> = attributeRepository.deleteById(attributeId)
}