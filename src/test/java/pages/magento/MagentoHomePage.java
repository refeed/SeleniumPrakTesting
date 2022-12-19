package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Helper;

public class MagentoHomePage {
    private WebDriver driver;

    private By loginButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    private By signUpButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");

    public MagentoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public MagentoLoginPage clickLoginButton() {
        Helper.getByWaitingElementToBeVisible(driver, loginButton).click();
        return new MagentoLoginPage(driver);
    }
    public CreateAccountPage clickCreateAnAccount() {
        Helper.getByWaitingElementToBeVisible(driver, signUpButton).click();
        return new CreateAccountPage(driver);
    }
    // get url
    public String getUrlCreateAccount() {
        return driver.getCurrentUrl();
    }
}
