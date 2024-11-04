package com.example.webshop.model

data class OrderPositonCreateRequest(
    val productId: String,
    val quantity: Long,
) {

}
