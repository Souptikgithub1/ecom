package com.ats.atsbookmyshow.service.impl

import com.ats.atsbookmyshow.domain.CategoryAttribute
import com.ats.atsbookmyshow.service.CategoryAttributeService
import com.ats.atsbookmyshow.utils.StringConstants
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class CategoryAttributeServiceImpl(
    val reactiveMongoTemplate: ReactiveMongoTemplate
): CategoryAttributeService {

    override fun search(categoryId: String, searchValue: String?, page: Int, pageSize: Int): Flux<CategoryAttribute> {
        val query = Query()
        query.addCriteria(Criteria.where(StringConstants.CATEGORY_ID).isEqualTo(categoryId))

        if (searchValue != null) {
            query.addCriteria(Criteria.where(StringConstants.ATTRIBUTE_NAME).regex(searchValue, "i"))
        }
        query.skip(((page-1) * pageSize).toLong())
        query.limit(pageSize)
        return reactiveMongoTemplate.find(query, CategoryAttribute::class.java)
    }
}