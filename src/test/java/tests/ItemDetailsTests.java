package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;

public class ItemDetailsTests extends BaseTests {

    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test(groups = {"Regression"})
    @Description("Verify item name and price on details page")
    @Attachment(value = "screenshot", type = "image/png")
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME, "Checking the product name");
        Assert.assertEquals(itemDetailsPage.getItemPrice(), ITEM_PRICE, "Checking the price of a product");

    }

    @Test(groups = {"Regression"})
    @Description("Verify description on details page")
    @Attachment(value = "screenshot", type = "image/png")
    public void verifyItemDescriptionOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), ITEM_DESCRIPTION,
                "Checking the product description");
    }


}
