package com.example.design_log.validation
import android.widget.EditText

class Validation {

    fun validateLogin(email: EditText, password: EditText) : Int{
        return if (!(email.length() >= VariableLenght.LENGHT_ERROR.lenght)) 1
        else if (!(email.text.toString().contains(VariableAt.EMAIL_ERROR.at))) 2
        else if (!(password.length() >= VariableLenght.LENGHT_ERROR.lenght)) 3
        else 4
    }

    fun validateRegister(username: EditText, email: EditText, password: EditText, confirmPassword: EditText) : Int {
        return if(!(username.length() >= VariableLenght.USERNAME_LENGHT_ERROR.lenght)) 0
        else if (!(email.length() >= VariableLenght.LENGHT_ERROR.lenght)) 1
        else if (!(email.text.toString().contains(VariableAt.EMAIL_ERROR.at))) 2
        else if (!(password.length() >= VariableLenght.LENGHT_ERROR.lenght)) 3
        else if (confirmPassword != password) 4
        else 5
    }

}





