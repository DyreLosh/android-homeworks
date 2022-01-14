package com.example.todoapp

import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val nameTask: String,
    val timeGenerationTask: LocalDateTime,
    val accomplishmentTask: Boolean
) : Parcelable
