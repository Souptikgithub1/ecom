package com.ats.atsbookmyshow.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("user")
data class User(

        @Field
        var name: String,
        @Field
        var dateOfBirth: Long,
        @Field
        var mobNo: String,
        @Field
        var emailId: String,
        @Field
        var sex: String
) {
        @Id
        @Field
        lateinit var id: String
}
