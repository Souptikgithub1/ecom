/*
package com.ats.atsbookmyshow.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration

@Configuration
class CouchbaseConfig : AbstractCouchbaseConfiguration() {

    @Value("\${couchbase.bootstrap-host}")
    private val host: String? = null

    @Value("\${couchbase.bucket.user}")
    private val userName: String? = null

    @Value("\${couchbase.bucket.password}")
    private val password: String? = null

    @Value("\${couchbase.bucket.name}")
    private val bucketName: String? = null

    override fun getConnectionString(): String? {
        return host
    }

    override fun getUserName(): String? {
        return userName
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getBucketName(): String? {
        return bucketName
    }
}*/
