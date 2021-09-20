package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.CategoryAttribute
import com.ats.atsbookmyshow.dto.CategoryAttributesRequestDto
import com.ats.atsbookmyshow.repository.AttributeRepository
import com.ats.atsbookmyshow.repository.CategoryAttributesRepository
import com.ats.atsbookmyshow.repository.CategoryRepository
import com.ats.atsbookmyshow.utils.CommonUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/categoryattributes")
class CategoryAttributesController(
    val categoryAttributesRepository: CategoryAttributesRepository,
    val categoryRepository: CategoryRepository,
    val attributeRepository: AttributeRepository
) {

    /*@PostMapping
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
    }*/

    @PostMapping
    fun create(@RequestBody categoryAttributesRequestDto: CategoryAttributesRequestDto): Mono<CategoryAttribute> {
        return categoryRepository.findById(categoryAttributesRequestDto.categoryId)
            .flatMap { cat ->
                val categoryAttribute = CategoryAttribute()
                CommonUtils.copyCategoryToCategoryAttributes(cat, categoryAttribute)

                attributeRepository.findById(categoryAttributesRequestDto.attributeId)
                    .flatMap { attr ->
                        CommonUtils.copyAttributeToCategoryAttribute(attr, categoryAttribute)
                        categoryAttribute.uoms = categoryAttributesRequestDto.uoms
                        categoryAttribute.validValues = categoryAttributesRequestDto.validValues
                        categoryAttributesRepository.save(categoryAttribute)
                    }
            }
    }
}