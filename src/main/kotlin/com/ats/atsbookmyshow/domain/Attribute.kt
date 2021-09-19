package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("attribute")
data class Attribute(
    @Id
    val attributeId: String? = ObjectId.get().toHexString(),
    val attributeName: String? = null,
    val uoms: List<String>? = mutableListOf(),
    val validValues: List<String>? = mutableListOf(),
    val dataType: String? = null
)
