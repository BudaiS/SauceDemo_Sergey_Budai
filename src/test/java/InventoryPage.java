import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    private By addToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartLocator = By.cssSelector("a[class='shopping_cart_link']");
    private By getShoppingCartTitle = By.id("continue-shopping");

    public void addToCart() {
        driver.findElement(addToCartLocator).click();
    }

    public void shoppingCart() {
        driver.findElement(shoppingCartLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getShoppingCartTitle));

    }


}
