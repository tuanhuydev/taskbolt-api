package com.tuanhuydev.taskbolt.application.usecases

import com.tuanhuydev.model.generated.model.Task
import com.tuanhuydev.model.generated.model.TaskStatus
import com.tuanhuydev.taskbolt.application.ports.incoming.TaskUseCase

class TaskService : TaskUseCase {
    override fun getTasks(): List<Task> {
        return listOf(
            Task(id = "task-1", title = "Set up CI/CD pipeline", status = TaskStatus.in_progress, description = "Configure GitHub Actions for automated build and deployment"),
            Task(id = "task-2", title = "Set up Database", status = TaskStatus.in_progress, description = "Configure PostgreSQL database for the application"),
            Task(id = "task-3", title = "Set up migration", status = TaskStatus.pending, description = "Configure Flyway for database migrations")
        )
    }
}