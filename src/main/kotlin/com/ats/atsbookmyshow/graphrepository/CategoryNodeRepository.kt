package com.ats.atsbookmyshow.graphrepository

import com.ats.atsbookmyshow.graphdomain.CategoryNode
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CategoryNodeRepository: Neo4jRepository<CategoryNode, Long> {
    fun findByCategoryName(categoryName: String): CategoryNode

    @Query("MATCH (parent:Category),(child:Category) WHERE parent.categoryId=\$parentCategoryId AND child.categoryId=\$childCategoryId CREATE (parent)<-[r:BELONGS_TO]-(child) RETURN 'true' ")
    fun createChildParentRelation(parentCategoryId: String?, childCategoryId: String?): String

    @Query("MATCH (parent:Category),(child:Category) WHERE parent.categoryId=\$parentCategoryId AND child.categoryId IN \$childCategoryId CREATE (parent)<-[r:BELONGS_TO]-(child) RETURN 'true' ")
    fun createParentChildrenRelation(parentCategoryId: String?, childCategoryId: List<String>?): List<String>

    fun findByDepth(depth: Int): List<CategoryNode>
}