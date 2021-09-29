package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.Attribute
import com.ats.atsbookmyshow.repository.AttributeRepository
import com.ats.atsbookmyshow.service.AttributeService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/attributes")
class AttributeController(
    val attributeRepository: AttributeRepository,
    val attributeService: AttributeService
) {

    @PostMapping
    fun create(@RequestBody attribute: Attribute): Mono<Attribute> = attributeRepository.save(attribute)

    @PostMapping("/search")
    fun search(@RequestParam(value = "searchValue", required = false) searchValue: String,
               @RequestParam(value = "page", defaultValue = "1", required = false) page: Int,
               @RequestParam(value = "pageSize", defaultValue = "10", required = false) pageSize: Int): Flux<Attribute> {
        return attributeService.search(searchValue, page, pageSize)
    }

    @GetMapping
    fun findAll(): Flux<Attribute> = attributeRepository.findAll()

    @DeleteMapping("/{attributeId}")
    fun deleteById(@PathVariable("attributeId") attributeId: String): Mono<Void> = attributeRepository.deleteById(attributeId)
}