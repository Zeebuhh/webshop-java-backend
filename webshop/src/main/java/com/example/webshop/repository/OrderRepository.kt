package com.example.webshop.repository

import com.example.webshop.model.OrderCreateRequest
import com.example.webshop.model.OrderResponse
import com.example.webshop.model.OrderStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class OrderRepository {

    val orders = mutableListOf<OrderResponse>()

    fun save(request: OrderCreateRequest): OrderResponse {
        val orderResponse = OrderResponse(
            UUID.randomUUID().toString(),
            request.customerId,
            LocalDateTime.now(),
            OrderStatus.NEW,
            emptyList()

        )

        orders.add(orderResponse)
        return orderResponse
    }

    fun findById(orderId: String): OrderResponse? {
        return orders.find{ it.id == orderId }
    }

}
