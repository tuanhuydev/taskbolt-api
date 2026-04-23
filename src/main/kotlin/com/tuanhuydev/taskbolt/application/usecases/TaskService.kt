package com.tuanhuydev.taskbolt.application.usecases

import com.tuanhuydev.taskbolt.application.ports.incoming.TaskUseCase
import com.tuanhuydev.taskbolt.application.ports.outgoing.TaskRepository
import com.tuanhuydev.taskbolt.domain.model.Task

class TaskService(
    private val taskRepository: TaskRepository
) : TaskUseCase {
    override fun getTasks(): List<Task> {
        return taskRepository.findAll()
    }
}