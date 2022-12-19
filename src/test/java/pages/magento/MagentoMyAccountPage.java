package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Helper;

public class MagentoMyAccountPage {
    private WebDriver driver;

    private By accountButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By logoutButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");

    public MagentoMyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        Helper.getByWaitingElementToBeVisible(driver, accountButton).click();
        Helper.getByWaitingElementToBeVisible(driver, logoutButton).click();
    }
}
