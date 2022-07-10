
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestFirst extends BaseTest {


    @Test
    public void firstTest() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.positiveLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
        inventoryPage.addToCart();
        inventoryPage.shoppingCart();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        cartPage.nameCheckInCart();
        cartPage.priceCheckInCart();


    }

}
