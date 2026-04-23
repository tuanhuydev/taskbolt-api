package com.tuanhuydev.taskbolt.infrastructure.incoming

import com.tuanhuydev.model.generated.model.TaskResponseSchema
import com.tuanhuydev.model.generated.model.TaskStatusSchema
import com.tuanhuydev.taskbolt.application.ports.incoming.TaskUseCase
import com.tuanhuydev.taskbolt.domain.model.Task
import com.tuanhuydev.taskbolt.domain.model.TaskStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskRestController(private val taskUseCase: TaskUseCase) {
    @GetMapping()
    fun getTasks(): List<TaskResponseSchema> {
        return taskUseCase.getTasks().map { it.toResponseSchema() }
    }

    private fun Task.toResponseSchema(): TaskResponseSchema {
        return TaskResponseSchema(
            id = id,
            title = title,
            description = description,
            status = when (status) {
                TaskStatus.PENDING -> TaskStatusSchema.pending
                TaskStatus.IN_PROGRESS -> TaskStatusSchema.in_progress
                TaskStatus.COMPLETED -> TaskStatusSchema.completed
            }
        )
    }
}