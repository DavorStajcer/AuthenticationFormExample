package com.example.auth.domain.entities

class SingUpParameters (
    email: String,
    password: String,
    val suername : String,
    val confrimPassword : String
): LogInParameters(email, password) {
}