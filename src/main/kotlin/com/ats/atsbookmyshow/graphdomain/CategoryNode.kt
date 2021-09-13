package com.ats.atsbookmyshow.graphdomain

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node("Category")
data class CategoryNode(
    val categoryId: String? = null,
    val categoryName: String? = null,
    val categoryDescription: String? = null,
    val depth: Int? = 0,
    val activeIndicator: Boolean? = true,

    @Id @GeneratedValue
    var id: Long?
)