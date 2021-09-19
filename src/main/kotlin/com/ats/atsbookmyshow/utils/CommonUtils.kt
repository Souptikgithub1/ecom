package com.ats.atsbookmyshow.utils

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.domain.CategoryAttributes
import com.ats.atsbookmyshow.graphdomain.CategoryNode

object CommonUtils {
    fun mapCategoryToCategoryNode(category: Category): CategoryNode {
        return CategoryNode(category.categoryId,
            category.categoryName,
            category.categoryDescription,
            category.depth,
            category.activeIndicator,
            category.parentCategoryId,null)
    }

    fun copyCategoryToCategoryAttributes(category: Category, categoryAttributes: CategoryAttributes): CategoryAttributes {
        categoryAttributes.categoryId = category.categoryId
        categoryAttributes.categoryName = category.categoryName
        categoryAttributes.categoryDescription = category.categoryDescription
        categoryAttributes.depth = category.depth
        categoryAttributes.activeIndicator = category.activeIndicator
        categoryAttributes.parentCategoryId = category.parentCategoryId
        return categoryAttributes
    }
}