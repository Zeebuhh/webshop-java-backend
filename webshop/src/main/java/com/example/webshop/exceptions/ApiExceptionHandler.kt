package com.example.webshop.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.net.http.HttpRequest

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(Throwable::class)
    fun handleErrors(request: HttpServletRequest, exception: Throwable): ResponseEntity<ErrorInfo> {

        println(exception.message)

        val(code, message) = when (exception){
            is WebshopException -> exception.statusCode to exception.message
            else -> HttpStatus.INTERNAL_SERVER_ERROR to (exception.message ?: "An error occured")
        }

        val errorInfo = ErrorInfo(message, request.contextPath)
        return ResponseEntity(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR)

    }

}

data class ErrorInfo(
    val error: String,
    val path: String
)
