package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class ProductsTests extends BaseTests {

    private final static ArrayList<String> FILTER_NAME_A_TO_Z = new ArrayList<>(
            Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"));
    private final static ArrayList<String> FILTER_NAME_Z_TO_A = new ArrayList<>(
            Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                    "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"));
    private final static ArrayList<String> FILTER_PRICE_LOW_TO_HIGH = new ArrayList<>(
            Arrays.asList("$7.99", "$9.99", "$15.99", "$15.99", "$29.99", "$49.99"));
    private final static ArrayList<String> FILTER_PRICE_HIGH_TO_LOW = new ArrayList<>(
            Arrays.asList("$49.99", "$29.99", "$15.99", "$15.99", "$9.99", "$7.99"));
    private final static String A_TO_Z = "Name (A to Z)";
    private final static String Z_TO_A = "Name (Z to A)";
    private final static String LOW_TO_HIGH = "Price (low to high)";
    private final static String HIGH_TO_LOW = "Price (high to low)";


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
    public void filterAToZ() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilter(A_TO_Z);
        Assert.assertEquals(productsPage.getItemNameOnFilter(), FILTER_NAME_A_TO_Z, "");
    }

    @Test(groups = {"Regression"})
    public void filterZToA() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilter(Z_TO_A);
        Assert.assertEquals(productsPage.getItemNameOnFilter(), FILTER_NAME_Z_TO_A, "");
    }

    @Test(groups = {"Regression"})
    public void filterLowToHigh() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilter(LOW_TO_HIGH);
        Assert.assertEquals(productsPage.getItemPriceOnFilter(), FILTER_PRICE_LOW_TO_HIGH, "");
    }

    @Test(groups = {"Regression"})
    public void filterHighToLow() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFilter(HIGH_TO_LOW);
        Assert.assertEquals(productsPage.getItemPriceOnFilter(), FILTER_PRICE_HIGH_TO_LOW, "");
    }


}
