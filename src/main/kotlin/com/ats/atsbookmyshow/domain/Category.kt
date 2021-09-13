package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("category")
data class Category(
    val categoryName: String? = null,
    val categoryDescription: String? = null,
    val depth: Int? = 0,
    val activeIndicator: Boolean? = true,
    val parentCategoryId: String? = null,

    @Id
    val categoryId: String? = ObjectId.get().toHexString()
)
