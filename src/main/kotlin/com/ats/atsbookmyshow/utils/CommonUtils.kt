package com.ats.atsbookmyshow.utils

import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.graphdomain.CategoryNode

object CommonUtils {
    fun mapCategoryToCategoryNode(category: Category): CategoryNode {
        return CategoryNode(category.categoryId, category.categoryName, category.categoryDescription, category.depth , category.activeIndicator, null)
    }
}