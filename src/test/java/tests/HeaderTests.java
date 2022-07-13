package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class HeaderTests extends BaseTests {
    HomePage homePage;
    @BeforeClass
    public void initialise() {

        homePage = new HomePage(driver);
    }
    @Test
    public void logoutTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickMenuButton();
        productsPage.clickLogoutMenuButton();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "");



    }

    @Test
    public void closeMenuTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickMenuButton();
        productsPage.clickCloseMenuButton();
        Assert.assertFalse(productsPage.isLogoutButtonDisplayed());


    }

}
