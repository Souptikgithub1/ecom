package com.ats.atsbookmyshow.service.impl

import com.ats.atsbookmyshow.service.ProductService
import com.ats.atsbookmyshow.utils.StringConstants
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findAll
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductServiceImpl(
    var reactiveMongoTemplate: ReactiveMongoTemplate
): ProductService {

    override fun save(productMap: MutableMap<String, Any>): Mono<MutableMap<String, Any>> {
        return reactiveMongoTemplate.save(productMap, StringConstants.PRODUCT_COLLECTION)
    }

    override fun findAll(): Flux<MutableMap<String, Any>> {
        return reactiveMongoTemplate.findAll<MutableMap<String, Any>>(StringConstants.PRODUCT_COLLECTION)
            . map { parseProduct(it) }
    }

    override fun findById(id: String): Mono<MutableMap<String, Any>> {
        return reactiveMongoTemplate.findById<MutableMap<String, Any>>(id, StringConstants.PRODUCT_COLLECTION)
            .map { parseProduct(it) }
    }

    private fun parseProduct(product: MutableMap<String, Any>): MutableMap<String, Any> {
        product["_id"] = product["_id"].toString()
        return product
    }
}