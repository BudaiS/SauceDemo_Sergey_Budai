/*import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartTests extends BaseTest {

    @Before
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void cartTests() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        WebElement expectedTextTitle = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String expectedResultTitle = expectedTextTitle.getText();
        WebElement expectedPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        String expectedResultPrice = expectedPrice.getText();
        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        shoppingCartBadge.click();
        WebElement actualTextTitle = driver.findElement(By.cssSelector(".inventory_item_name"));
        String actualResultTitle = actualTextTitle.getText();
        WebElement actualPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        String actualResultPrice = actualPrice.getText();
        Assert.assertEquals(actualResultTitle, expectedResultTitle, "Checking if the product name in the cart matches");
        Assert.assertEquals(actualResultPrice, expectedResultPrice, "Checking if the price of the item in the cart matches");


    }


}
*/

