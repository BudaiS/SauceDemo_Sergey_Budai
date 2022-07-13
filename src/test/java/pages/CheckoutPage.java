package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HomePage {
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipPostalCodeInput = By.id("postal-code");
    private final By errorMessages = By.cssSelector(".error-button");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void setFirstNameInput(String firstName) {
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
        return driver.findElement(errorMessages).isDisplayed();
    }
    public String  getErrorMessageText() {

        return driver.findElement(errorMessages).getText();
    }

}
