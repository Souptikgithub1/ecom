package com.ats.atsbookmyshow.dto

import com.ats.atsbookmyshow.domain.Attribute

data class CategoryAttributesRequestDto(
    val categoryId: String? = null,
    val attributes: MutableList<Attribute>? = mutableListOf()
)
