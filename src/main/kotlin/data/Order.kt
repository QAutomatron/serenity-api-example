package data

data class Order(val id: Long,
                 val petId: Long,
                 val quantity: Int,
                 val shipDate: String,
                 val status: OrderStatus,
                 val complete: Boolean = false)