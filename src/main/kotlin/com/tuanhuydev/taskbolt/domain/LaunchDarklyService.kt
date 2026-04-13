package com.tuanhuydev.taskbolt.domain

import com.launchdarkly.sdk.LDContext
import com.launchdarkly.sdk.server.LDClient
import com.launchdarkly.sdk.server.LDConfig
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class LaunchDarklyService {
    @Value("\${launchdarkly.sdk.key}") private val sdkKey: String? = null

    private lateinit var client: LDClient

    @PostConstruct
    fun init() {
        val config = LDConfig.Builder().build()
        client = LDClient(sdkKey, config)

        if (client.isInitialized) {
            println("✅ LaunchDarkly initialized using .env key")
        }
    }
    fun isFeatureEnabled(featureKey: String, userKey: String): Boolean {
        val context = LDContext.create(userKey)
        return client.boolVariation(featureKey, context, false)
    }

}