import categories.CategoryOne
import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Issue
import net.thucydides.core.annotations.Steps
import net.thucydides.core.annotations.Title
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import step.PetSteps

@RunWith(SerenityRunner::class)
@Category(CategoryOne::class)
class AddPet_Test {

    @Steps
    private lateinit var petSteps: PetSteps

    @Test
    @Issue("#1")
    @Title("Add Pet")
    fun add_pet_ok() {

        val pet = DataManager.makeSomePet()

        petSteps.addPet(pet)
        petSteps.addedPetShouldBeSameAs(pet)
    }
}
