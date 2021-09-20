package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("categoryAttribute")
data class CategoryAttribute(

    @Id
    var categoryAttributeId: String? = ObjectId.get().toHexString(),

    //category properties
    var categoryId: String? = null,
    var categoryName: String? = null,
    var categoryDescription: String? = null,
    var depth: Int? = 0,
    var activeIndicator: Boolean? = true,
    var parentCategoryId: String? = null,

    //attribute properties
    var attributeId: String? = null,
    var attributeName: String? = null,
    var uoms: MutableList<String>? = mutableListOf(),
    var validValues: MutableList<String>? = mutableListOf(),
    var dataType: String? = null,
    var attributeGroup: String? = null
)
