package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends HomePage {
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipPostalCodeInput = By.id("postal-code");
    private final By errorMessages = By.cssSelector(".error-message-container ");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        driver.findElement(cancelButton).click();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void setFirstNameInput(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setZipPostalCodeInput(String zipPostalCode) {
        driver.findElement(zipPostalCodeInput).sendKeys(zipPostalCode);
    }

    public void continueCheckout(String firstName, String lastName, String zipPostalCode) {
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setZipPostalCodeInput(zipPostalCode);
        clickContinueButton();
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages));
        return driver.findElement(errorMessages).isDisplayed();
    }

    public String getErrorMessageText() {

        return driver.findElement(errorMessages).getText();
    }

}
