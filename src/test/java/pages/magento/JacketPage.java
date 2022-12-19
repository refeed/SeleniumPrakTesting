package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Helper;

public class JacketPage {
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    public JacketPage(WebDriver driver) {
        this.driver = driver;
    }

    public DetailJacketPage selectJacket1() {
        WebElement jacket1 = Helper.getByWaitingElementToBeVisible(driver, new By.ByLinkText("Proteus Fitness Jackshirt"));
        jacket1.click();
        return new DetailJacketPage(this.driver);

    }
    public DetailJacketPage selectJacket2() {
        WebElement jacket2 = Helper.getByWaitingElementToBeVisible(driver, new By.ByLinkText("Jupiter All-Weather Trainer"));
        jacket2.click();
        return new DetailJacketPage(this.driver);

    }
}
