package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests{
    final static String PRODUCT_NAME = "Sauce Labs Onesie";

    @Test
    public void verifyItemPriceOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(PRODUCT_NAME), "$7.99",
                "Checking the price of a product");

    }

    @Test
    public void verifyItemNameOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductName(PRODUCT_NAME), PRODUCT_NAME,
                "Checking the product name");

    }
    @Test
    public void verifyItemDescriptionOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductDescription(PRODUCT_NAME),
                "Rib snap infant onesie for the junior automation engineer in development. " +
                        "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                "Checking the product description");

    }
}
