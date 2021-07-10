package com.example.auth.presentation.sign_up.form

import com.example.auth.presentation.log_in.form.IFormParameters
import com.example.auth.presentation.log_in.form.LogInFormParameters
import com.example.auth.presentation.models.ConfirmPassword
import com.example.auth.presentation.models.Email
import com.example.auth.presentation.models.Password
import com.example.auth.presentation.models.Username

class SingUpFormParameters : IFormParameters {

    val username : Username
     val email : Email
    val password : Password
    val confirmPassword : ConfirmPassword

    constructor(username: Username,email: Email, password: Password,confirmPassword: ConfirmPassword){
        this.username = username
        this.email = email
        this.password = password
        this.confirmPassword = confirmPassword
    }

    constructor(u : CharSequence?, eString : String?,pString : String?,cpString : String?){
        this.username = Username(u?.toString()?.trim())
        this.email = Email(eString)
        this.password = Password(pString)
        this.confirmPassword = ConfirmPassword(cpString,pString)
    }
    constructor(uString : String?, e : CharSequence?,pString : String?,cpString : String?){
        this.username = Username(uString)
        this.email = Email(e?.toString()?.trim())
        this.password = Password(pString)
        this.confirmPassword = ConfirmPassword(cpString,pString)
    }
    constructor(uString : String?, eString : String?,p : CharSequence?,cpString : String?){
        this.username = Username(uString)
        this.email = Email(eString)
        this.password = Password(p?.toString()?.trim())
        this.confirmPassword = ConfirmPassword(cpString,p?.toString()?.trim())
    }
    constructor(uString : String?, eString : String? ,pString : String?,cp : CharSequence?){
        this.username = Username(uString)
        this.email = Email(eString)
        this.password = Password(pString)
        this.confirmPassword = ConfirmPassword(cp?.toString()?.trim(),pString)
    }

    fun isValid() : Boolean = email.isValid() && password.isValid()
}