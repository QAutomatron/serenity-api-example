package step

import apiUrl
import data.Pet
import io.restassured.http.ContentType
import io.restassured.response.Response
import net.serenitybdd.rest.SerenityRest
import net.thucydides.core.annotations.Step
import net.thucydides.core.steps.ScenarioSteps
import org.junit.Assert.assertEquals

open class PetSteps : ScenarioSteps() {

    private var addedPet: Pet? = null
    private var deletedPetResponse: Response? = null

    @Step
    open fun addPet(pet: Pet) {

        addedPet = SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(pet)
                .log().body()
                .expect().statusCode(200)
                .log().ifValidationFails()
                .`when`().post("$apiUrl/pet").`as`(Pet::class.java)
    }

    @Step
    open fun addedPetShouldBeSameAs(pet: Pet) {
        assertEquals("Wrong added pet",
                pet,
                addedPet)
    }

    @Step
    open fun deletePet(pet: Pet) {

        deletedPetResponse = SerenityRest
                .given()
                .`when`().delete("$apiUrl/pet/${pet.id}")
    }

    @Step
    open fun petShouldBeDeleted() {
        assertEquals("Pet should be deleted",
                200,
                deletedPetResponse?.statusCode)
    }
}
