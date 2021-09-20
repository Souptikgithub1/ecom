package com.ats.atsbookmyshow.dto

import com.ats.atsbookmyshow.domain.Attribute

data class CategoryAttributesRequestDto(
    var categoryId: String,
    var attributeId: String,

    var uoms: MutableList<String>,
    var validValues: MutableList<String>? = mutableListOf(),
)
