package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends HomePage {
    private static Select select;


    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By productPrice = By.cssSelector(".inventory_item_price");
    private final By productLink = By.cssSelector("a[id$=link]");
    private final By productSortContainer = By.cssSelector("select.product_sort_container");
    private final By productName = By.cssSelector(".inventory_item_name");
    private final By productDescription = By.cssSelector(".inventory_item_desc");
    String productContainerLocator
            = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductSortContainerDisplayed() {
        return driver.findElement(productSortContainer).isDisplayed();
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath
                (String.format(productContainerLocator, productsName)));
    }

    public void clickAddToCartButton(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(addToCartButton).click();
    }

    public String getProductPrice(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(productPrice).getText();
    }

    public void openItemByName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();

    }

    public String getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(productName).getText();
    }

    public String getProductDescription(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(productDescription).getText();
    }


    public void clickFilter(String filterText) {
        select = new Select(driver.findElement(productSortContainer));
        select.selectByVisibleText(filterText);
    }


    public ArrayList<String> getItemNameOnFilter() {
        List<WebElement> itemName = driver.findElements(productName);
        ArrayList<String> listName = new ArrayList<>();
        itemName.stream().map(WebElement::getText).forEach(listName::add);
        return listName;
    }

    public ArrayList<String> getItemPriceOnFilter() {
        List<WebElement> itemName = driver.findElements(productPrice);
        ArrayList<String> listName = new ArrayList<>();
        itemName.stream().map(WebElement::getText).forEach(listName::add);
        return listName;
    }


}
