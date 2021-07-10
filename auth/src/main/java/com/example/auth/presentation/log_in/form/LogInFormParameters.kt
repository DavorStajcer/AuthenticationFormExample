package com.example.auth.presentation.log_in.form

import com.example.auth.presentation.models.Email
import com.example.auth.presentation.models.Password

class LogInFormParameters : IFormParameters  {
    val email : Email
    val password : Password

    constructor(email: Email, password: Password){
        this.email = email
        this.password = password
    }

    constructor(e : CharSequence?, pString : String?){
        this.email = Email(e?.toString()?.trim())
        this.password = Password(pString)
    }
    constructor(eString : String?, p : CharSequence?){
        this.email = Email(eString)
        this.password = Password(p?.toString()?.trim())
    }

    fun copyWith(
        email : Email?,
        password : Password?
    ) : LogInFormParameters = LogInFormParameters(
        email ?: this.email,
        password ?: this.password
    )

    fun isValid() : Boolean = email.isValid() && password.isValid()
}