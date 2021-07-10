package com.example.auth.presentation.models

import com.example.auth.util.AuthFormInputValidator

class Password(
    private val content : String?
){
    val errorMessage : String? = AuthFormInputValidator.mapToPasswordError(content)

    fun isValid() : Boolean = errorMessage == null && content != null && content.isNotEmpty() && content.isNotBlank()
}