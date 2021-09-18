package com.ats.atsbookmyshow.service.impl

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.dto.CategoryRequestDto
import com.ats.atsbookmyshow.graphdomain.CategoryNode
import com.ats.atsbookmyshow.graphrepository.CategoryNodeRepository
import com.ats.atsbookmyshow.repository.CategoryRepository
import com.ats.atsbookmyshow.service.CategoryService
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CategoryServiceImpl(
    val categoryRepository: CategoryRepository,
    val categoryNodeRepository: CategoryNodeRepository,
    var reactiveMongoTemplate: ReactiveMongoTemplate
    ): CategoryService {

    override fun createCategory(categoryRequestDto: CategoryRequestDto): Mono<Category> {
        return categoryRepository.save(
            Category(categoryRequestDto.categoryName,
            categoryRequestDto.categoryDescription,
            categoryRequestDto.depth,
            categoryRequestDto.activeIndicator,
            categoryRequestDto.parentCategoryId)
        )
            .doOnNext {
                categoryNodeRepository.save(CategoryNode(it.categoryId,
                it.categoryName,
                it.categoryDescription,
                it.depth,
                it.activeIndicator, it.parentCategoryId, null))
            }
            .doOnNext {
                 var result = if (null!=categoryRequestDto.parentCategoryId && categoryRequestDto.parentCategoryId!="") {
                     categoryNodeRepository.createChildParentRelation(categoryRequestDto.parentCategoryId,
                        it.categoryId)
                } else {
                    true
                }
                result
            }
    }

    override fun findDistinctDepths(): Flux<Int> {
        return reactiveMongoTemplate.findDistinct("depth", Category::class.java, Int::class.java)
    }


}