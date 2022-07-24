package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    public void clickOnFilterZtoA() {
        select = new Select(driver.findElement(productSortContainer));
        select.selectByVisibleText("Name (Z to A)");
    }

    public String getFirstItemNameOnFilterZtoA() {
        List<WebElement> itemName = driver.findElements(productName);
        ArrayList<String> listName = new ArrayList<>();
        for (WebElement webElement : itemName) {
            listName.add(webElement.getText());
        }
        listName.sort(Comparator.reverseOrder());
        return listName.get(0);


    }

    public String getLastItemNameOnFilterZtoA() {
        List<WebElement> itemName = driver.findElements(productName);
        ArrayList<String> listName = new ArrayList<>();
        for (WebElement webElement : itemName) {
            listName.add(webElement.getText());
        }
        listName.sort(Comparator.reverseOrder());
        return listName.get(listName.size() - 1);


    }

    public void clickOnFilterAtoZ() {
        select = new Select(driver.findElement(productSortContainer));
        select.selectByVisibleText("Name (A to Z)");
    }

    public String getFirstItemNameOnFilterAtoZ() {
        List<WebElement> itemName = driver.findElements(productName);
        ArrayList<String> listName = new ArrayList<>();
        for (WebElement webElement : itemName) {
            listName.add(webElement.getText());
        }
        listName.stream().sorted();
        return listName.get(0);


    }

    public String getLastItemNameOnFilterAtoZ() {
        List<WebElement> itemName = driver.findElements(productName);
        ArrayList<String> listName = new ArrayList<>();
        for (WebElement webElement : itemName) {
            listName.add(webElement.getText());
        }
        listName.stream().sorted();
        return listName.get(listName.size() - 1);


    }

    public void clickFilterOnPriceLowToHigh() {
        select = new Select(driver.findElement(productSortContainer));
        select.selectByVisibleText("Price (low to high)");
    }


    public double getFirstItemPriceOnFilterLowToHigh() {
        List<WebElement> itemPrice = driver.findElements(productPrice);
        ArrayList<String> listPrice = new ArrayList<>();
        double[] valuePrice = new double[itemPrice.size()];
        for (int i = 0; i < itemPrice.size(); i++) {
            listPrice.add(itemPrice.get(i).getText().substring(1));
            valuePrice[i] = Double.parseDouble(listPrice.get(i));
        }
        Arrays.stream(valuePrice).sorted();

        return valuePrice[0];
    }

    public double getLastItemPriceOnFilterLowToHigh() {
        List<WebElement> itemPrice = driver.findElements(productPrice);
        ArrayList<String> listPrice = new ArrayList<>();
        double[] valuePrice = new double[itemPrice.size()];
        for (int i = 0; i < itemPrice.size(); i++) {
            listPrice.add(itemPrice.get(i).getText().substring(1));
            valuePrice[i] = Double.parseDouble(listPrice.get(i));
        }
        Arrays.stream(valuePrice).sorted();
        return valuePrice[valuePrice.length - 1];
    }

    public void clickFilterOnPriceHighToLow() {
        select = new Select(driver.findElement(productSortContainer));
        select.selectByVisibleText("Price (high to low)");
    }

    public double getLastItemPriceOnFilterHighToLow() {
        List<WebElement> itemPrice = driver.findElements(productPrice);
        ArrayList<String> listPrice = new ArrayList<>();
        double[] valuePrice = new double[itemPrice.size()];
        for (int i = 0; i < itemPrice.size(); i++) {
            listPrice.add(itemPrice.get(i).getText().substring(1));
            valuePrice[i] = Double.parseDouble(listPrice.get(i));
        }
        Arrays.stream(valuePrice).sorted();
        return valuePrice[valuePrice.length - 1];
    }

    public double getFirstItemPriceOnFilterHighToLow() {
        List<WebElement> itemPrice = driver.findElements(productPrice);
        ArrayList<String> listPrice = new ArrayList<>();
        double[] valuePrice = new double[itemPrice.size()];
        for (int i = 0; i < itemPrice.size(); i++) {
            listPrice.add(itemPrice.get(i).getText().substring(1));
            valuePrice[i] = Double.parseDouble(listPrice.get(i));
        }
        Arrays.stream(valuePrice).sorted();
        return valuePrice[0];
    }


}
