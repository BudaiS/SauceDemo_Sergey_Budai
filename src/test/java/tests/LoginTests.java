package tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTests {




    @Test
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Check if the element has appeared on ProductsPage");

    }

    @Test
    public void negativeWrongPasswordLoginTests() {  // enter wrong password
        loginPage.setUsernameInput("standard_user");
        loginPage.setPasswordInput("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Checking for an error message");
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Password is required",
                "We check the appearance of an error message about an incorrect password entry");

    }

    @Test
    public void negativeWrongUsernameLoginTests() {  // enter wrong username
        loginPage.setUsernameInput("");
        loginPage.setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Checking for an error message");
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username is required",
                "We check the appearance of an error message about an incorrect username entry");

    }


}
