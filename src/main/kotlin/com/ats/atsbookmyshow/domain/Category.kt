package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("category")
data class Category(
    val categoryName: String? = null,
    val categoryDescription: String? = null,
    val activeIndicator: Boolean? = true,

    @Id
    val categoryId: String? = ObjectId.get().toHexString()
)
