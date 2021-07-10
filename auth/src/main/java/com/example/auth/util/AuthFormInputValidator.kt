package com.example.auth.util

object AuthFormInputValidator {

    fun mapToUsernameError(username : String?) : String?{
        if(username == null || username.isBlank() || username.isEmpty())
            return null
        if(username.length < 4)
            return "Must contain more than 4 characters."
        return null
    }

    fun mapToEmailError(email : String?) : String?{
            if(email == null || email.isBlank() || email.isEmpty())
                return null
            if(!email.contains('.') || !email.contains('@'))
                return "Enter a valid email"
            return null
    }

    fun mapToPasswordError(password : String?) : String?{
        if(password == null || password.isBlank() || password.isEmpty())
            return null
        if(password.length < 4)
            return "Must contain more than 4 characters."
        return null
    }
    fun mapToConfrimPasswordError(confirmPassword : String?,password : String?) : String?{
        if(confirmPassword != password && confirmPassword != null && confirmPassword.isNotEmpty())
            return "Passwords must mach"
        return null
    }
}