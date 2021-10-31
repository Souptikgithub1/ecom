package com.ats.atsbookmyshow.service

import com.ats.atsbookmyshow.domain.CategoryAttribute
import reactor.core.publisher.Flux

interface CategoryAttributeService {
    fun search(categoryId: String, searchValue: String?, page: Int, pageSize: Int): Flux<CategoryAttribute>
}