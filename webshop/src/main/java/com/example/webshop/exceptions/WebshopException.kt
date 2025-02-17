package com.example.webshop.exceptions

import org.springframework.http.HttpStatus

class WebshopException(
    override val message: String,
    val statusCode: HttpStatus
): RuntimeException(message)
