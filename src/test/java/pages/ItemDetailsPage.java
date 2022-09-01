package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemDetailsPage extends HomePage {

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(css = "button[id^=add-to-cart]")
    private WebElement addToCartButton;

    @FindBy(css = ".inventory_details_name")
    private WebElement itemName;
    @FindBy(css = ".inventory_details_price")
    private WebElement itemPrice;
    @FindBy(css = ".inventory_details_desc")
    private WebElement itemDescription;


    public ItemDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickBackToProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(backToProductsButton));
        backToProductsButton.click();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }


}
