package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTests{
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";

    ItemDetailsPage itemDetailsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    HomePage homePage;

    @BeforeClass
    public void initialise() {

        itemDetailsPage = new ItemDetailsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    public void positiveCheckoutTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        homePage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.continueCheckout("First", "Last", "12345");
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isBackHomeButtonDisplayed(),
                "Checking the appearance of the 'BACKHOME' button");
        Assert.assertEquals(checkoutCompletePage.getCheckoutComplete(), "CHECKOUT: COMPLETE!",
                "Checking for a Success Message");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Checking what brought us to 'ProductsPage'");
    }
    @Test
    public void negativeWrongFirstNameTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        homePage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.continueCheckout("", "Last", "12345");
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(),
                "Checking for an error message");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is required",
                "We check the appearance of an error message about an incorrect First Name entry");


    }
    @Test
    public void negativeWrongLastNameTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        homePage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.continueCheckout("First", "", "12345");
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(),
                "Checking for an error message");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is required",
                "We check the appearance of an error message about an incorrect Last Name entry");


    }
    @Test
    public void negativeWrongZipPostalCodeTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        homePage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.continueCheckout("First", "Last", "");
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(),
                "Checking for an error message");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Postal Code is required",
                "We check the appearance of an error message about an incorrect Zip/Postal Code entry");


    }
}
