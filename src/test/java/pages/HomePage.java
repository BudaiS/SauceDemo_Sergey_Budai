package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final By shoppingCartButton = By.cssSelector("a.shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By twitterLink = By.xpath("//a[text()='Twitter']");
    private final By facebookLink = By.xpath("//a[text()='Facebook']");
    private final By linkedInLink = By.xpath("//a[text()='LinkedIn']");
    private final By closeMenuButton = By.id("react-burger-cross-btn");
    private final By logoutButton = By.id("logout_sidebar_link");





    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }
    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }
    public void clickCloseMenuButton() {
        driver.findElement(closeMenuButton).click();
    }
    public void clickTwitterLink() {
        driver.findElement(twitterLink).click();
    }
    public void clickFacebookLink() {
        driver.findElement(facebookLink).click();
    }
    public void clickLinkedInLink() {
        driver.findElement(linkedInLink).click();
    }
    public void clickLogoutMenuButton () {
        driver.findElement(logoutButton).click();
    }
    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

}
