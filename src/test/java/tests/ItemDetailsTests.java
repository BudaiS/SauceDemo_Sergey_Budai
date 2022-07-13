package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;

public class ItemDetailsTests extends BaseTests {
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";

    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME, "Checking the product name");
        Assert.assertEquals(itemDetailsPage.getItemPrice(), "$49.99", "Checking the price of a product");

    }

    @Test
    public void verifyItemDescriptionOnDetailsPage() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemDescription(),
                "It's not every day that you come across a midweight quarter-zip fleece jacket " +
                        "capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                "Checking the product description");
    }


}
