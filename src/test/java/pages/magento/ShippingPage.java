package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Helper;

public class ShippingPage {
    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    private By email = new By.ById("customer-email");
    private By firstName = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input");
    private By lastName = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input");
    private By streetAddress = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input");
    private By city = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input");
    private By sttProv = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div/select"); //
    private By zip = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input");
    private By country = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select");
    private By phone = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input");
    private By shipMeth = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input");
    private By nxtBtn = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button");
    public void setShippingtxt(String eml,
                               String frsNm,
                               String lstNm,
                               String strtAdd,
                               String cty,
                               String zp,
                               String phne){
        WebElement email = Helper.getByWaitingElementToBeVisible(driver, this.email);
        WebElement firstName = Helper.getByWaitingElementToBeVisible(driver, this.firstName);
        WebElement lastName = Helper.getByWaitingElementToBeVisible(driver, this.lastName);
        WebElement streetAddress = Helper.getByWaitingElementToBeVisible(driver, this.streetAddress);
        WebElement city = Helper.getByWaitingElementToBeVisible(driver, this.city);
        WebElement zip = Helper.getByWaitingElementToBeVisible(driver, this.zip);
        WebElement phone = Helper.getByWaitingElementToBeVisible(driver, this.phone);

        email.sendKeys(eml);
        firstName.sendKeys(frsNm);
        lastName.sendKeys(lstNm);
        streetAddress.sendKeys(strtAdd);
        city.sendKeys(cty);
        zip.sendKeys(zp);
        phone.sendKeys(phne);
    }

    public void setStateProv_country_shipM1(){
        WebElement waitProv = Helper.getByWaitingElementToBeVisible(driver, sttProv);
        Select prov = new Select(waitProv);
        prov.selectByIndex(1);

        WebElement waitCountry = Helper.getByWaitingElementToBeVisible(driver, country);
        Select cntry = new Select(waitCountry);
        cntry.selectByIndex(3);
//
//        WebElement waitShipMeth = Helper.getByWaitingElementToBeVisible(driver, shipMeth);
//        waitShipMeth.click();
    }

    public TransPage nextBtn(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement waitNxtBtn = driver.findElement(nxtBtn);

        waitNxtBtn.click();
        return new TransPage(driver);
    }







 }
