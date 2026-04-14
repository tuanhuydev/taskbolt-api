package com.tuanhuydev.taskbolt.infrastructure.incoming

import com.tuanhuydev.model.generated.model.Task
import com.tuanhuydev.taskbolt.application.ports.incoming.TaskUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskRestController(private val taskUseCase: TaskUseCase) {
    @GetMapping()
    fun getTasks(): List<Task> {
       return taskUseCase.getTasks()
    }
}