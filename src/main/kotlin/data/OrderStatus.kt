package data

import com.fasterxml.jackson.annotation.JsonValue

enum class OrderStatus {

    Placed, Approved, Delivered;

    @JsonValue
    override fun toString() = this.name.toLowerCase()
}