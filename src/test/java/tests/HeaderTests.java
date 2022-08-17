package tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTests extends BaseTests {

    private static final String EXPECTED_FACEBOOK_URL = "https://www.facebook.com/saucelabs";
    private static final String EXPECTED_TWITTER_URL = "https://twitter.com/saucelabs";
    private static final String EXPECTED_LINKEDIN_URL = "https://www.linkedin.com/company/sauce-labs/";


    @Test(groups = {"Regression"})
    public void logoutTests() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickMenuButton();
        productsPage.clickLogoutMenuButton();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Checking the ability to logout on the site");


    }

    @Test(groups = {"Regression"})
    public void closeMenuTests() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickMenuButton();
        productsPage.clickCloseMenuButton();
        Assert.assertFalse(productsPage.isLogoutButtonDisplayed(), "Checking if the popup is closed");


    }

    @Test(groups = {"Regression"})
    public void facebookLink() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickFacebookLink();
        Assert.assertEquals(productsPage.getUrlFromNewlyOpenedTab(), EXPECTED_FACEBOOK_URL, "Checking the link facebook");
    }

    @Test(groups = {"Regression"})
    public void twitterLink() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickTwitterLink();
        Assert.assertEquals(productsPage.getUrlFromNewlyOpenedTab(), EXPECTED_TWITTER_URL, "Checking the link twitter");
    }

    @Test(groups = {"Regression"})
    public void linkedInLink() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickLinkedInLink();
        Assert.assertEquals(productsPage.getUrlFromNewlyOpenedTab(), EXPECTED_LINKEDIN_URL, "Checking the link linkedIn");
    }

}
