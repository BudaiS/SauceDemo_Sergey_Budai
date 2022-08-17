package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public abstract class HomePage extends BasePage {
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
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        driver.findElement(shoppingCartButton).click();
    }

    public void clickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        driver.findElement(menuButton).click();

    }

    public void clickCloseMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeMenuButton));
        driver.findElement(closeMenuButton).click();
    }

    public void clickTwitterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(twitterLink));
        driver.findElement(twitterLink).click();
    }

    public void clickFacebookLink() {
        wait.until(ExpectedConditions.elementToBeClickable(facebookLink));
        driver.findElement(facebookLink).click();
    }

    public void clickLinkedInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkedInLink));
        driver.findElement(linkedInLink).click();
    }

    public void clickLogoutMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public boolean isLogoutButtonDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
    }

    public String getUrlFromNewlyOpenedTab() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> allWindowsList = allWindows.stream().toList();
        driver.switchTo().window(allWindowsList.get(1));
        String pageUrl = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(allWindowsList.get(0));
        return pageUrl;
    }


}
