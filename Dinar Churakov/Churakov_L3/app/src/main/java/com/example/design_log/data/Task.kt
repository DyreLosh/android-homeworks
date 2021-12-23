package com.example.design_log.data

import java.time.LocalDateTime

data class Task(
    val completedTask: Boolean,
    val taskText: String,
    val date: LocalDateTime
)
