package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {
    private WebDriver driver;

    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginButtonBy = By.id("login-button");
    private By errorMsgContainerBy = By.className("error-message-container");

    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertUsernameField(String str) {
        driver.findElement(usernameBy).sendKeys(str);
    }

    public void insertPasswordField(String str) {
        driver.findElement(passwordBy).sendKeys(str);
    }

    public void clickLoginButton() {
        // TODO: Might be better to return Inventory page here
        driver.findElement(loginButtonBy).click();
    }

    public WebElement getErrorMsgContainer() {
        return driver.findElement(errorMsgContainerBy);
    }
}
