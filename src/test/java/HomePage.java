import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @FindBy(id = "user-name")
    private WebElement usernameLocator;
    @FindBy(id = "password")
    private WebElement passwordLocator;
    private By loginButtonLocator = By.id("login-button");

    private By shoppingCart = By.cssSelector("a[class='shopping_cart_link']");


    public void typeUsername(String username) {
        usernameLocator.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordLocator.sendKeys(password);

    }

    public void submitLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public void positiveLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        driver.findElement(loginButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart));

    }


}