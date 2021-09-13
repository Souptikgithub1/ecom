package com.ats.atsbookmyshow.dto

data class CategoryRequestDto(
    val categoryName: String? = null,
    val categoryDescription: String? = null,
    val activeIndicator: Boolean? = true,
    val parentCategoryId: String? = null
)