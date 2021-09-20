package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("category")
open class Category(
    var categoryName: String? = null,
    var categoryDescription: String? = null,
    var depth: Int? = 0,
    var activeIndicator: Boolean? = true,
    var parentCategoryId: String? = null,

    @Id
    var categoryId: String? = ObjectId.get().toHexString()
)
