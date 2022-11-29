import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.saucedemo.SauceDemoLoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceDemoFrontendTest {
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
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.insertUsernameField("standard_user");
        loginPage.insertPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        // It should redirect to inventory.html
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginFailed() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.insertUsernameField("standard_user");
        loginPage.insertPasswordField("wrongpassword");
        loginPage.clickLoginButton();
        // It shouldn't redirect to inventory.html
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void testLoginNoPassword() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.insertUsernameField("wrong_user");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMsgContainer()
                        .getText().contains("Password is required"));
    }

    @Test
    public void testLoginNoUsername() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.insertPasswordField("wrong_password");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMsgContainer()
                .getText().contains("Username is required"));
    }
}
