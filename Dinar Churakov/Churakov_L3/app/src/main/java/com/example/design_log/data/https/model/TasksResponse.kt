package com.example.design_log.data.https.model

data class TasksResponse(

    val userId: Int,
    val id: Int,
    val text: String,
    val isCompleted: Boolean
)
