package com.example.design_log.validation

enum class VariableLenght(val lenght : Int) {
    LENGHT_ERROR(7),
    USERNAME_LENGHT_ERROR(4);
}
enum class VariableAt(val  at : String) {
    EMAIL_ERROR("@")
}