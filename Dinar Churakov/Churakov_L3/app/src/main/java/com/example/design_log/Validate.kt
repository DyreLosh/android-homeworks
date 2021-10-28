package com.example.design_log
import android.widget.EditText

class Validate() {

    fun validateLogin(email: EditText, password: EditText) : Int{
        if (!(email.length() >= 6))  return 1
        else if (!(email.text.toString().contains("@"))) return 2
        else if (!(password.length() >= 7)) return 3
        else return 4
    }
}



