package com.example.webshop.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OrderCreateRequest(
    @JsonProperty("customerId") val customerId: String
)
