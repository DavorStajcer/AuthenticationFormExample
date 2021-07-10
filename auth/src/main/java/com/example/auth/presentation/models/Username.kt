package com.example.auth.presentation.models

import com.example.auth.util.AuthFormInputValidator

class Username(
    private val content : String?
){
    var errorMessage : String? = null

    init {
        errorMessage = AuthFormInputValidator.mapToUsernameError(content)
    }

    fun isValid() : Boolean = errorMessage == null && content != null && content.isNotEmpty() && content.isNotBlank()
}