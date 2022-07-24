package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessages = By.cssSelector(".error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsernameInput(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        setUsernameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessages).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessages).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }


}
