package com.example.webshop.controller

import com.example.webshop.model.OrderCreateRequest
import com.example.webshop.model.OrderPositonCreateRequest
import com.example.webshop.model.OrderResponse
import com.example.webshop.repository.OrderRepository
import com.example.webshop.repository.ProductRepository
import com.example.webshop.service.OrderService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    val orderService = OrderService()

    @PostMapping("/orders")
    fun createOrder(
        @RequestBody request: OrderCreateRequest
    ): OrderResponse{
       return orderService.createOrder(request)
    }

    @PostMapping("/order/{id}/positions")
    fun createOrderPosition(
        @PathVariable(name = "id") orderId: String,
        @RequestBody request: OrderPositonCreateRequest
    ){
        orderService.createNewPositionForOrder(orderId, request)
    }
}