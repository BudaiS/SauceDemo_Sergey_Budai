package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public class BaseTests {
    protected String USERNAME = "standard_user";
    protected String PASSWORD = "secret_sauce";
    protected String PRODUCT_NAME = "Sauce Labs Bolt T-Shirt";
    protected String ITEM_PRICE = "$15.99";
    protected String FIRST_NAME = "First";
    protected String LAST_NAME = "Last";
    protected String ZIP_POSTAL_CODE = "12345";
    protected String EMPTY = "";

    protected String ITEM_DESCRIPTION = "Get your testing superhero on with the Sauce Labs bolt T-shirt. " +
            "From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @Parameters({"browser"})

    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("fireFox")) {
            WebDriverManager.safaridriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));

    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }

}
