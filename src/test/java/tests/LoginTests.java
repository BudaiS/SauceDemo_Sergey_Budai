package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    private final static String ERROR_PASSWORD_MESSAGE = "Epic sadface: Password is required";
    private final static String ERROR_USERNAME_MESSAGE = "Epic sadface: Username is required";


    @Test(groups = {"Smoke"})
    @Description("positive login tests")
    @Attachment(value = "screenshot", type = "image/png")
    public void loginTests() {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Check if the element has appeared on ProductsPage");

    }


    @Test(groups = {"Negative"}, dataProvider = "negativeLoginTests")
    public void negativeLoginTests(String userName, String password, String errorMessage) {  // enter wrong username
        loginPage.setUsernameInput(userName);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Checking for an error message");
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage,
                "We check the appearance of an error message about an incorrect username entry");

    }

    @DataProvider
    public Object[][] negativeLoginTests() {
        return new Object[][]{
                {EMPTY, PASSWORD, ERROR_USERNAME_MESSAGE},
                {USERNAME, EMPTY, ERROR_PASSWORD_MESSAGE},
                {EMPTY, EMPTY, ERROR_USERNAME_MESSAGE},
        };

    }


}
