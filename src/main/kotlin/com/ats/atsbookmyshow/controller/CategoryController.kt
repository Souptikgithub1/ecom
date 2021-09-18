package com.ats.atsbookmyshow.controller

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.dto.CategoryRequestDto
import com.ats.atsbookmyshow.graphdomain.CategoryNode
import com.ats.atsbookmyshow.graphrepository.CategoryNodeRepository
import com.ats.atsbookmyshow.graphservice.CategoryNodeService
import com.ats.atsbookmyshow.repository.CategoryRepository
import com.ats.atsbookmyshow.service.CategoryService
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@RestController
@RequestMapping("/categories")
@CrossOrigin
class CategoryController(
    var categoryRepository: CategoryRepository,
    var categoryService: CategoryService,
    var categoryNodeService: CategoryNodeService,
    var categoryNodeRepository: CategoryNodeRepository,
    var reactiveMongoTemplate: ReactiveMongoTemplate
) {

    @PostMapping("")
    fun createCategory(@RequestBody categoryMono: Mono<CategoryRequestDto>): Mono<Category> {
        return categoryMono.flatMap { categoryService.createCategory(it) }
    }

    @PostMapping("/multiple")
    fun createMultipleCategories(@RequestBody categoryFlux: Flux<Category>): Flux<Category> {
        return categoryFlux.flatMap { categoryRepository.save(it) }
    }

    @GetMapping
    fun getAllCategories(): Flux<Category> {
        return categoryRepository.findAll();
    }

    @GetMapping("/{categoryName}")
    fun getCategoryByName(@PathVariable("categoryName") categoryName: String): Mono<Category> {
        return categoryRepository.findByCategoryName(categoryName)
    }

    @GetMapping("/byDepth/{depth}")
    fun getCategoryByDepth(@PathVariable("depth") depth: Int): Flux<Category> {
        return categoryRepository.findByDepth(depth)
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

    @GetMapping("/allparent/{categoryId}")
    fun getAllParentNodesByCategoryId(@PathVariable("categoryId") categoryId: String): Flux<CategoryNode> {
        return categoryNodeRepository.findAllParentByCategoryId(categoryId).stream().sorted { o1, o2 -> o1.depth?.compareTo(o2.depth!!)!! }.toFlux()
    }

    @GetMapping("/distinctdepth")
    fun findDistinctDepths(): Flux<Int> {
        return categoryService.findDistinctDepths()
    }

    @GetMapping("/test")
    fun test(): Flux<MutableMap<String, Any>> {
        return categoryService.findCategories()
    }
}