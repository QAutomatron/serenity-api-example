package step

import apiUrl
import data.Order
import data.OrderStatus
import io.restassured.http.ContentType
import net.serenitybdd.rest.SerenityRest
import net.thucydides.core.annotations.Step
import net.thucydides.core.steps.ScenarioSteps
import org.junit.Assert.assertEquals

open class ShopSteps : ScenarioSteps() {

    private var placedOrder: Order? = null

    @Step
    open fun order(order: Order) {
        placedOrder = SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(order)
                .log().body()
                .expect().statusCode(200)
                .log().ifValidationFails()
                .`when`().post("$apiUrl/store/order").`as`(Order::class.java)
    }

    @Step
    open fun orderStateShouldBeSameAs(expectedState: OrderStatus) {
        assertEquals("Wrong order state",
                expectedState,
                placedOrder?.status)
    }
}
