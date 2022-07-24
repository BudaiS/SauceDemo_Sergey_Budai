package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends HomePage {
    private final By removeButton = By.cssSelector("button[id^=remove]");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By itemDescription = By.cssSelector(".inventory_item_desc");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        driver.findElement(removeButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }


}
