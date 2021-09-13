package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.dto.CategoryRequestDto
import com.ats.atsbookmyshow.graphdomain.CategoryNode
import com.ats.atsbookmyshow.graphrepository.CategoryNodeRepository
import com.ats.atsbookmyshow.graphservice.CategoryNodeService
import com.ats.atsbookmyshow.repository.CategoryRepository
import com.ats.atsbookmyshow.service.CategoryService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/categories")
@CrossOrigin
class CategoryController(
    var categoryRepository: CategoryRepository,
    var categoryService: CategoryService,
    var categoryNodeService: CategoryNodeService,
    var categoryNodeRepository: CategoryNodeRepository
) {

    @PostMapping("")
    fun createCategory(@RequestBody categoryMono: Mono<CategoryRequestDto>): Mono<Category> {
        return categoryMono.flatMap { categoryService.createCategory(it) }
    }

    @PostMapping("/multiple")
    fun createMultipleCategories(@RequestBody categoryFlux: Flux<Category>): Flux<Category> {
        return categoryFlux.flatMap { categoryRepository.save(it) }
    }

    @GetMapping("/{categoryName}")
    fun getCategoryByName(@PathVariable("categoryName") categoryName: String): Mono<Category> {
        return categoryRepository.findByCategoryName(categoryName)
    }

    @PostMapping("/createParentChildRelation")
    fun createParentChildRelation(@RequestParam("parentCatId") parentCatId: String, @RequestParam("childCatId") childCatId: String): String {
        return categoryNodeRepository.createChildParentRelation(parentCatId, childCatId)
    }

    @PostMapping("/createParentChildrenRelation")
    fun createParentChildrenRelation(@RequestParam("parentCatId") parentCatId: String, @RequestBody childCatId: List<String>): List<String> {
        return categoryNodeRepository.createParentChildrenRelation(parentCatId, childCatId)
    }

    @DeleteMapping("")
    fun deleteAllCategories(): Mono<Void> {
        return categoryRepository.deleteAll()
    }
}