package com.ats.atsbookmyshow.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("attribute")
data class Attribute(
    @Id
    var attributeId: String? = ObjectId.get().toHexString(),
    var attributeName: String? = null,
    var uoms: List<String>? = mutableListOf(),
    var validValues: List<String>? = mutableListOf(),
    var dataType: String? = null,
    var attributeGroup: String? = null
)
