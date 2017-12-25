package data

import java.util.*

data class Pet (
        val id: Long? = null,
        val category: Category? = null,
        val name: String? = null,
        val photoUrls: ArrayList<String> = ArrayList<String>(),
        val tags: ArrayList<Tag> = ArrayList<Tag>(),
        val status: PetStatus? = null)