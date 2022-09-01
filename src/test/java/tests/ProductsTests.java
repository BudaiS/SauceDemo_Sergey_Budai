package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
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


    @Test(groups = {"Regression"}, dataProvider = "allItemsDetails")
    public void verifyItemPriceNameDescriptionOnProductsPage(String name, String price, String description) {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductName(name), name,
                "Checking the product name");
        Assert.assertEquals(productsPage.getProductPrice(name), price,
                "Checking the price of a product");
        Assert.assertEquals(productsPage.getProductDescription(name), description,
                "Checking the product description");

    }

    @DataProvider
    public Object[][] allItemsDetails() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
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
