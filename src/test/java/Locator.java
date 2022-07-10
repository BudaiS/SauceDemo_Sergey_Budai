import org.openqa.selenium.By;


public class Locator {
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.name("password");
    By websiteIcon = By.className("login_logo");
    By getLoginInputLocator = By.tagName("value='Login'");
    By linkText = By.linkText("locked_out_user");
    By partialLinkText = By.partialLinkText("Password for all users:");
    By xpathAttribute = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    By xpathText = By.xpath("//a[text()='Twitter']");
    By xpathPartialAttribute = By.xpath("//a[contains(@class,'shopping')]");
    By xpathPartialText = By.xpath("//a[contains(text(),'Lin')]");
    By xpathAncestor = By.xpath("//option[text()='Name (A to Z)']//ancestor::select");
    By xpathDescendant = By.xpath("//div[@class='bm-burger-button']//descendant::button");
    By xpathFollowingSibling = By.xpath("//li[@class='social_facebook']//following-sibling::li");
    By xpathParent = By.xpath("//option[@value='az']//parent::select");
    By xpathPrecedingSibling = By.xpath("//img[@class='bm-icon']//preceding-sibling::button");
    By xpathAnd = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory' and @id='add-to-cart-sauce-labs-bike-light']");
    By cssClass = By.cssSelector(".product_sort_container");
    By cssClassClass = By.cssSelector(".submit-button.btn_action");
    By cssClass_Class = By.cssSelector(".login-box .submit-button ");
    By cssId = By.cssSelector("#login-button");
    By cssTagName = By.cssSelector("footer");
    By cssTagNameClass = By.cssSelector("select.product_sort_container");
    By cssAtrVal = By.cssSelector("[data-test='product_sort_container']");
    By cssAtrValue = By.cssSelector("[rel~='noreferrer']");
    By cssAttrValue = By.cssSelector("[name|='add']");
    By cssAttriVal = By.cssSelector("a[href^='https']");
    By cssAttributeValue = By.cssSelector("button[name$='backpack']");
    By cssAtValue = By.cssSelector("a[href*='twitter']");


}
