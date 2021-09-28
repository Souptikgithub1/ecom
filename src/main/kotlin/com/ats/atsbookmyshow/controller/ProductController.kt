package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.service.ProductService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/products")
@CrossOrigin
class ProductController(
    var productService: ProductService
) {

    @PostMapping
    fun createProduct(@RequestBody productMap: MutableMap<String, Any>): Mono<MutableMap<String, Any>> {
        return productService.save(productMap)
    }

    @GetMapping
    fun findAll(): Flux<MutableMap<String, Any>> {
        return productService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): Mono<MutableMap<String, Any>> {
        return productService.findById(id)
    }

    @GetMapping("/first6")
    fun first6products(): Flux<MutableMap<String, Any>> {
        return productService.find6Products()
    }
}