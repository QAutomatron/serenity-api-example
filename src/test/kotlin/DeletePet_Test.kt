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
class DeletePet_Test {

    @Steps
    private lateinit var petSteps: PetSteps

    @Test
    @Issue("#2")
    @Title("Delete Pet")
    fun delete_pet_ok() {

        val pet = DataManager.makeSomePet()

        petSteps.addPet(pet)
        petSteps.deletePet(pet)
        petSteps.petShouldBeDeleted()
    }
}
