import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement actualTitle = driver.findElement(By.cssSelector("div.inventory_item_name"));
    private String actualResultTitle = actualTitle.getText();
    private String expectedResultTitle = "Sauce Labs Backpack";

    public void nameCheckInCart() {
        Assert.assertEquals(actualResultTitle, expectedResultTitle, " ");
    }

    private WebElement actualPrice = driver.findElement(By.cssSelector("div.inventory_item_price"));
    private String actualResultPrice = actualPrice.getAttribute("wholeText");
    private String expectedResultPrice = "$29.99";

    public void priceCheckInCart() {
        Assert.assertEquals(actualResultPrice, expectedResultPrice, " ");
    }


}

