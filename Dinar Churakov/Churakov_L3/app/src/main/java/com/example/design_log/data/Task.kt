package com.example.design_log.data

import java.time.LocalDateTime

data class Task(
    val tasksCheckBox: Boolean,
    val taskText: String,
    val date: LocalDateTime
)
