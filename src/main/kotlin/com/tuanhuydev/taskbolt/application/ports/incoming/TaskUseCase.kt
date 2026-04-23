package com.tuanhuydev.taskbolt.application.ports.incoming

import com.tuanhuydev.taskbolt.domain.model.Task

interface TaskUseCase {
    fun getTasks(): List<Task>
}