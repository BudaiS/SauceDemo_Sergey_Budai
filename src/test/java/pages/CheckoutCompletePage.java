package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends HomePage {
    private final By backHomeButton = By.id("back-to-products");
    private final By checkoutComplete = By.cssSelector("span.title");


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }

    public String getCheckoutComplete() {
        return driver.findElement(checkoutComplete).getText();
    }
    public boolean isBackHomeButtonDisplayed() {
        return driver.findElement(backHomeButton).isDisplayed();
    }
}