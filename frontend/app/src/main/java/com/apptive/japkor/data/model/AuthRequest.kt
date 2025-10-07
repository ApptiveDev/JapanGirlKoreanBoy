package com.apptive.japkor.data.model

data class SignInRequest(
    val email: String,
    val password: String
)

data class SignUpRequest(
    val email: String,
    val password: String
)
