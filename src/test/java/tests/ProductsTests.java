package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTests extends BaseTests {
    private final static String FIRST_ITEM_NAME = "Sauce Labs Backpack";
    private final static String LAST_ITEM_NAME = "Test.allTheThings() T-Shirt (Red)";
    private final static double FIRST_ITEM_PRICE = 7.99;
    private final static double LAST_ITEM_PRICE = 49.99;

    @Test(groups = {"Regression"})
    public void verifyItemPriceNameDescriptionOnProductsPage() {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductPrice(PRODUCT_NAME), ITEM_PRICE,
                "Checking the price of a product");
        Assert.assertEquals(productsPage.getProductName(PRODUCT_NAME), PRODUCT_NAME,
                "Checking the product name");
        Assert.assertEquals(productsPage.getProductDescription(PRODUCT_NAME), ITEM_DESCRIPTION,
                "Checking the product description");

    }

    @Test(groups = {"Regression"})
    public void filterNameAtoZ() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickOnFilterAtoZ();
        Assert.assertEquals(productsPage.getFirstItemNameOnFilterAtoZ(), FIRST_ITEM_NAME, "1");
        Assert.assertEquals(productsPage.getLastItemNameOnFilterAtoZ(), LAST_ITEM_NAME, "2");
    }

    @Test(groups = {"Regression"})
    public void filterNameZtoA() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickOnFilterZtoA();
        Assert.assertEquals(productsPage.getFirstItemNameOnFilterZtoA(), LAST_ITEM_NAME, "3");
        Assert.assertEquals(productsPage.getLastItemNameOnFilterZtoA(), FIRST_ITEM_NAME, "4");
    }

    @Test(groups = {"Regression"})
    public void filterPriceLowToHigh() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilterOnPriceLowToHigh();
        Assert.assertEquals(productsPage.getFirstItemPriceOnFilterLowToHigh(), FIRST_ITEM_PRICE, "5");
        Assert.assertEquals(productsPage.getLastItemPriceOnFilterLowToHigh(), LAST_ITEM_PRICE, "6");
    }

    @Test(groups = {"Regression"})
    public void filterPriceHighToLow() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilterOnPriceHighToLow();
        Assert.assertEquals(productsPage.getFirstItemPriceOnFilterHighToLow(), LAST_ITEM_PRICE, "7");
        Assert.assertEquals(productsPage.getLastItemPriceOnFilterHighToLow(), FIRST_ITEM_PRICE, "8");
    }


}
