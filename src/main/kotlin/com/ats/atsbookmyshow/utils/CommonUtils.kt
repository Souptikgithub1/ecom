package com.ats.atsbookmyshow.utils

import com.ats.atsbookmyshow.domain.Attribute
import com.ats.atsbookmyshow.domain.Category
import com.ats.atsbookmyshow.domain.CategoryAttribute
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

    fun copyCategoryToCategoryAttributes(category: Category, categoryAttribute: CategoryAttribute): CategoryAttribute {
        categoryAttribute.categoryId = category.categoryId
        categoryAttribute.categoryName = category.categoryName
        categoryAttribute.categoryDescription = category.categoryDescription
        categoryAttribute.depth = category.depth
        categoryAttribute.activeIndicator = category.activeIndicator
        categoryAttribute.parentCategoryId = category.parentCategoryId
        return categoryAttribute
    }

    fun copyAttributeToCategoryAttribute(attribute: Attribute, categoryAttribute: CategoryAttribute): CategoryAttribute {
        categoryAttribute.attributeId = attribute.attributeId
        categoryAttribute.attributeName = attribute.attributeName
        categoryAttribute.attributeGroup = attribute.attributeGroup
        categoryAttribute.dataType = attribute.dataType
       return categoryAttribute
    }
}