package com.ats.atsbookmyshow.graphservice

import com.ats.atsbookmyshow.graphdomain.CategoryNode
import reactor.core.publisher.Mono

interface CategoryNodeService {
    fun getCategoryNodeByCategoryName(categoryName: String): Mono<CategoryNode>
}