package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Helper;


public class MagentoLoginPage {
    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By loginButton = new By.ById("send2");

    private WebDriver driver;

    public MagentoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MagentoMyAccountPage login(String email, String password) {
        Helper.getByWaitingElementToBeVisible(driver, this.password).sendKeys(password);
        Helper.getByWaitingElementToBeVisible(driver, this.email).sendKeys(email);
        Helper.getByWaitingElementToBeVisible(driver, loginButton).click();
        return new MagentoMyAccountPage(driver);
    }
}
