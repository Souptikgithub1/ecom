package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("categoryAttributes")
data class CategoryAttributes(

    @Id
    var categoryId: String? = null,
    var categoryName: String? = null,
    var categoryDescription: String? = null,
    var depth: Int? = 0,
    var activeIndicator: Boolean? = true,
    var parentCategoryId: String? = null,

    var attributes: MutableList<Attribute>? = mutableListOf()
)
