package com.tuanhuydev.taskbolt.application.ports.incoming

import com.tuanhuydev.model.generated.model.Task

interface TaskUseCase {
    fun getTasks(): List<Task>
}