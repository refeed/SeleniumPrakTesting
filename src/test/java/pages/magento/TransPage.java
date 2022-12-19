package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Helper;

public class TransPage {
    private WebDriver driver;
    private By orderSum = new By.ByXPath("/html/body/div[3]/main/div[2]/div/div[2]/aside/div[2]/div/div/div[1]");

    public TransPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderSummary(){
        WebElement sum1 = Helper.getByWaitingElementToBeVisible(driver, orderSum);

        return sum1.getText();
    }
}
