import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.google.SearchPage;
import pages.google.SearchResultPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TheInternetFrontendTest {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstFigureElem = driver.findElement(new By.ByClassName("figure"));

        Actions action = new Actions(driver);
        action.moveToElement(firstFigureElem).perform();

        WebElement firstFigcaptionElem = driver.findElement(new By.ByClassName("figcaption"));
        assertEquals("name: user1\nView profile", firstFigcaptionElem.getText());
    }

    @Test
    public void testKeyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputTargetElem = driver.findElement(new By.ById("target"));
        inputTargetElem.sendKeys(Keys.SHIFT);

        WebElement resultElement = driver.findElement(new By.ById("result"));

        assertEquals("You entered: SHIFT", resultElement.getText());
    }

    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnAElem = driver.findElement(new By.ById("column-a"));
        WebElement columnBElem = driver.findElement(new By.ById("column-b"));

        Actions action = new Actions(driver);
        action
                .dragAndDrop(columnAElem, columnBElem)
                .perform();

        assertEquals("B", columnAElem.getText());
        assertEquals("A", columnBElem.getText());
    }
}
