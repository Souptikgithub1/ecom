package com.ats.atsbookmyshow.service

import com.ats.atsbookmyshow.domain.Attribute
import reactor.core.publisher.Flux

interface AttributeService {
    fun search(searchValue: String?, page: Int, pageSize: Int): Flux<Attribute>
}