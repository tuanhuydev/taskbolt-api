package com.tuanhuydev.taskbolt.domain.model

enum class TaskStatus { PENDING, IN_PROGRESS, COMPLETED }

data class Task(
    val id: String,
    val title: String,
    val description: String?,
    val status: TaskStatus
)
