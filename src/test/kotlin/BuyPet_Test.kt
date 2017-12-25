import categories.CategoryTwo
import data.Order
import data.OrderStatus
import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Issue
import net.thucydides.core.annotations.Steps
import net.thucydides.core.annotations.Title
import org.joda.time.DateTime
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import step.ShopSteps

@RunWith(SerenityRunner::class)
@Category(CategoryTwo::class)
class BuyPet_Test {

    @Steps
    private lateinit var shopSteps: ShopSteps

    @Test
    @Issue("#3")
    @Title("Buy Pet")
    fun buy_pet() {

        val order = Order(1, 1, 1, DateTime.now().toString(), OrderStatus.Placed,false)

        shopSteps.order(order)
        shopSteps.orderStateShouldBeSameAs(OrderStatus.Placed)
    }
}
