package com.tuanhuydev.taskbolt.configuration

import com.tuanhuydev.taskbolt.application.ports.incoming.TaskUseCase
import com.tuanhuydev.taskbolt.application.usecases.TaskService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskConfiguration {

    @Bean
    fun taskUseCase(): TaskUseCase = TaskService()
}