package com.ats.atsbookmyshow.service.impl

import com.ats.atsbookmyshow.domain.Attribute
import com.ats.atsbookmyshow.service.AttributeService
import com.ats.atsbookmyshow.utils.StringConstants
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AttributeServiceImpl(
    val reactiveMongoTemplate: ReactiveMongoTemplate
): AttributeService {

    override fun search(searchValue: String?, page: Int, pageSize: Int): Flux<Attribute> {
        val query = Query()
        if (searchValue != null) {
            query.addCriteria(Criteria.where(StringConstants.ATTRIBUTE_NAME).regex(searchValue, "i"))
        }
        query.skip(((page-1) * pageSize).toLong())
        query.limit(pageSize)
        return reactiveMongoTemplate.find(query, Attribute::class.java)
    }
}