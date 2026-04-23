package com.tuanhuydev.taskbolt.infrastructure.outgoing.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface TaskJpaRepository : JpaRepository<TaskEntity, String>