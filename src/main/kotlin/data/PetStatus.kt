package data

import com.fasterxml.jackson.annotation.JsonValue

enum class PetStatus {

    Available, Pending, Sold;

    @JsonValue()
    override fun toString() = this.name.toLowerCase()
}