package com.ats.atsbookmyshow.graphservice.impl

import com.ats.atsbookmyshow.graphdomain.CategoryNode
import com.ats.atsbookmyshow.graphrepository.CategoryNodeRepository
import com.ats.atsbookmyshow.graphservice.CategoryNodeService
import org.springframework.data.neo4j.core.Neo4jTemplate
import org.springframework.data.neo4j.repository.query.QueryFragmentsAndParameters
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CategoryNodeServiceImpl(
    var categoryNodeRepository: CategoryNodeRepository
): CategoryNodeService{
    override fun getCategoryNodeByCategoryName(categoryName: String): Mono<CategoryNode> {
        return Mono.just(categoryNodeRepository.findByCategoryName(categoryName))

    }

}