import data.Category
import data.Pet
import data.PetStatus
import data.Tag
import java.util.ArrayList

object DataManager {

    fun makeSomePet(): Pet {

        val photoUrls = ArrayList<String>()
        photoUrls.add("http://example.com/fox.png")

        val tags = ArrayList<Tag>()
        tags.add(Tag(0, "cute"))

        return Pet(
                name = "Foxy",
                id = System.currentTimeMillis(),
                category = Category(0,"fox"),
                photoUrls = photoUrls,
                tags = tags,
                status = PetStatus.Available
                )
    }
}