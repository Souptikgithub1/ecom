package com.ats.atsbookmyshow.service

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.dto.CategoryRequestDto
import reactor.core.publisher.Mono

interface CategoryService {
    fun createCategory(categoryRequestDto: CategoryRequestDto): Mono<Category>
}