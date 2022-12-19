package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Helper {
    public static WebElement getByWaitingElementToBeVisible(WebDriver driver, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
}
