package com.tuanhuydev.taskbolt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskboltApplication

fun main(args: Array<String>) {
	runApplication<TaskboltApplication>(*args)
}
