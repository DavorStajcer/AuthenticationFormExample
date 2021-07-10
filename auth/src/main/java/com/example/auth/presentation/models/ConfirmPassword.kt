package com.example.auth.presentation.models

import com.example.auth.util.AuthFormInputValidator

class ConfirmPassword(
    private val content : String?,
     password : String?
){
    var errorMessage : String? = null

    init {
        errorMessage = AuthFormInputValidator.mapToConfrimPasswordError(content,password)
    }

    fun isValid() : Boolean = errorMessage == null && content != null && content.isNotEmpty() && content.isNotBlank()
}