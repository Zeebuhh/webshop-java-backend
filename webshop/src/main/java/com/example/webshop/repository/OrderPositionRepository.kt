package com.example.webshop.repository

import com.example.webshop.model.OrderPositionResponse

class OrderPositionRepository {

    val orderPositions = mutableListOf<OrderPositionResponse>()

    fun save(orderPositionResponse: OrderPositionResponse){
        orderPositions.add(orderPositionResponse)
    }

}
