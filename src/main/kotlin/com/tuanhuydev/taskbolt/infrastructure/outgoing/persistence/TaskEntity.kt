package com.tuanhuydev.taskbolt.infrastructure.outgoing.persistence

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tasks")
class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID) val id: String,
    val title: String,
    val description: String?,
    @Enumerated(EnumType.STRING) val status: TaskStatusEntity
)

enum class TaskStatusEntity { PENDING, IN_PROGRESS, COMPLETED }