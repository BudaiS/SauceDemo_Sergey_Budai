package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutCompletePage extends HomePage {
    private final By backHomeButton = By.id("back-to-products");
    private final By checkoutComplete = By.cssSelector("span.title");


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void clickBackHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        driver.findElement(backHomeButton).click();
    }

    public String getCheckoutComplete() {
        return driver.findElement(checkoutComplete).getText();
    }

    public boolean isBackHomeButtonDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        return driver.findElement(backHomeButton).isDisplayed();
    }
}