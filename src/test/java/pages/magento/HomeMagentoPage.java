package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Helper;

import java.time.Duration;

public class HomeMagentoPage {
    private WebDriver driver;
    private By menButton = new By.ById("ui-id-5");
    private By topsButton = new By.ById("ui-id-17");
    private By jcktButton = new By.ById("ui-id-19");

    public HomeMagentoPage(WebDriver driver) {
        this.driver = driver;
    }

    public JacketPage clickJacketOps() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebElement menBtn =  Helper.getByWaitingElementToBeVisible(driver, new By.ByXPath("ui-id-5"));
//       WebElement topsBtn =  Helper.getByWaitingElementToBeVisible(driver, new By.ById("ui-id-17"));
//       WebElement jcktBtn =  Helper.getByWaitingElementToBeVisible(driver, new By.ById("ui-id-19"));
        WebElement menBtn = driver.findElement(new By.ById("ui-id-5"));
        WebElement topsBtn = driver.findElement(new By.ById("ui-id-17"));
        WebElement jcktBtn = driver.findElement(new By.ById("ui-id-19"));


        Actions action1 = new Actions(driver);
        action1.clickAndHold(menBtn).perform();

        Actions action2 = new Actions(driver);
        action2.clickAndHold(topsBtn).perform();

        Actions action3 = new Actions(driver);
        action3.click(jcktBtn).perform();
        return new JacketPage(this.driver);

    }

    public WebDriver getDriver() {
        return driver;
    }
}
