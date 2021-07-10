package com.example.auth.domain.entities

open class LogInParameters (
    val email : String,
    val password : String,
        ) : IAuthParams
