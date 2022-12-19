package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Helper;

public class DetailJacketPage {
    private WebDriver driver;
    //jacket1
    private By sizeJacket1 = new By.ById("option-label-size-143-item-166");
    private By colorJacket1 = new By.ById("option-label-color-93-item-56");
    //jacket2
    private By sizeJacket2 = new By.ById("option-label-size-143-item-169");
    private By colorJacket2 = new By.ById("option-label-color-93-item-53");
    private By addItem = new By.ById("product-addtocart-button");
    private By clickCart = new By.ByClassName("showcart");
    private  By checkout = new By.ById("top-cart-btn-checkout");



    public DetailJacketPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void selectSizeJacket1() {
        WebElement sizeJkt = Helper.getByWaitingElementToBeVisible(driver,sizeJacket1);
        sizeJkt.click();
    }
    public void selectColorJacket1()  {

        WebElement colorJkt = Helper.getByWaitingElementToBeVisible(driver,colorJacket1);
        colorJkt.click();
    }
    public void selectSizeJacket2()  {

        WebElement sizeJkt = Helper.getByWaitingElementToBeVisible(driver,sizeJacket2);
        sizeJkt.click();
    }
    public void selectColorJacket2()  {

        WebElement colorJkt = Helper.getByWaitingElementToBeVisible(driver,colorJacket2);
        colorJkt.click();
    }

    public void addToCart()  {

        WebElement ai = Helper.getByWaitingElementToBeVisible(driver,addItem);
        ai.click();
    }
    public ShippingPage checkCart()  {

        Helper.getByWaitingElementToBeVisible(driver, new By.ByXPath("/html/body/div[2]/main/div[1]/div[2]/div/div/div/a"));
        WebElement cc = Helper.getByWaitingElementToBeVisible(driver,clickCart);
        cc.click();
        WebElement co = Helper.getByWaitingElementToBeVisible(driver,checkout);
        co.click();
        return new ShippingPage(driver);
    }
}
