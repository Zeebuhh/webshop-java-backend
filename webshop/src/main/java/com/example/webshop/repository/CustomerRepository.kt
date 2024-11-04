package com.example.webshop.repository

import com.example.webshop.model.CustomerResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerRepository {

    val customers = listOf(

        CustomerResponse(
            UUID.randomUUID().toString(),
            "Total",
            "Surprise",
            "blalbla@gmx.de"
        ),
        CustomerResponse(
            UUID.randomUUID().toString(),
            "Max",
            "Meier",
            "hexhexpompom@gmail.com")

    )

    fun findById(id: String): CustomerResponse? {
        return customers.find { it.id == id }

    }
}