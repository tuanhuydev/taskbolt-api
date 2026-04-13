package com.tuanhuydev.taskbolt.incoming

import com.tuanhuydev.taskbolt.domain.LaunchDarklyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskRestController(private val ldService: LaunchDarklyService) {

    @GetMapping()
    fun check(): String {
        val isEnabled: Boolean = ldService.isFeatureEnabled("isServiceOnline", "user-123")
        return if (isEnabled) "It's enabled" else "It's disabled"
    }
}