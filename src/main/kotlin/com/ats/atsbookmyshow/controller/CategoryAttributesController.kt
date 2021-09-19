package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.CategoryAttributes
import com.ats.atsbookmyshow.dto.CategoryAttributesRequestDto
import com.ats.atsbookmyshow.repository.CategoryAttributesRepository
import com.ats.atsbookmyshow.repository.CategoryRepository
import com.ats.atsbookmyshow.utils.CommonUtils
import org.springframework.beans.BeanUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@RestController
@RequestMapping("/categoryattributes")
class CategoryAttributesController(
    val categoryAttributesRepository: CategoryAttributesRepository,
    val categoryRepository: CategoryRepository
) {

    @PostMapping
    fun create(@RequestBody categoryAttributesRequestDto: CategoryAttributesRequestDto): Mono<CategoryAttributes> {
        return categoryAttributesRepository.findById(categoryAttributesRequestDto.categoryId!!)
            .flatMap { existingCatAttr ->
                existingCatAttr.attributes?.addAll(categoryAttributesRequestDto.attributes!!)
                categoryAttributesRepository.save(existingCatAttr)
            }
            .switchIfEmpty {
                categoryRepository.findById(categoryAttributesRequestDto.categoryId)
                    .flatMap { cat ->
                        val categoryAttributes = CategoryAttributes()
                        CommonUtils.copyCategoryToCategoryAttributes(cat, categoryAttributes)
                        categoryAttributes.attributes = categoryAttributesRequestDto.attributes
                        categoryAttributesRepository.save(categoryAttributes)
                    }
            }
    }
}