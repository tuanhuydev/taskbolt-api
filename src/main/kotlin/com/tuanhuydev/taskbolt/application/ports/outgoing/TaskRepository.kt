package com.tuanhuydev.taskbolt.application.ports.outgoing

import com.tuanhuydev.taskbolt.domain.model.Task

interface TaskRepository {
    fun findAll(): List<Task>
    fun findById(id: String): Task?
    fun save(task: Task): Task
    fun deleteById(id: String)
}