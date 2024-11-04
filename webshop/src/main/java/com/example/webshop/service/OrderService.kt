package com.example.webshop.service

import com.example.webshop.model.*
import com.example.webshop.repository.CustomerRepository
import com.example.webshop.repository.OrderPositionRepository
import com.example.webshop.repository.OrderRepository
import com.example.webshop.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(
    val productRepository: ProductRepository,
    val orderRepository: OrderRepository,
    val customerRepository: CustomerRepository,
    val orderPositionRepository: OrderPositionRepository
) {



    fun createOrder(request: OrderCreateRequest): OrderResponse {

        val customer: CustomerResponse = customerRepository.findById(request.customerId)
            ?: throw Exception("Customer not found")

        return orderRepository.save(request)
    }

    fun createNewPositionForOrder(
        orderId: String,
        request: OrderPositonCreateRequest): OrderPositionResponse
    {
        orderRepository.findById(orderId)?:
            throw Exception("Order not found")

        if(productRepository.findById(request.productId).isEmpty)
            throw Exception("Product not found")

        val orderPositionResponse = OrderPositionResponse(
            id = UUID.randomUUID().toString(),
            productId = request.productId,
            quantity = request.quantity
        )
        orderPositionRepository.save(orderPositionResponse)

        return orderPositionResponse

    }
}