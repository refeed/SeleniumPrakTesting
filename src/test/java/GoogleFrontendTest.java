import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.google.SearchPage;
import pages.google.SearchResultPage;

import static org.junit.Assert.assertTrue;

public class GoogleFrontendTest {
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
        driver.get("https://google.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.insertQueryInSearchBar("neysa");
        SearchResultPage resultPage = searchPage.clickSearchButton();
        assertTrue(resultPage
                .getPageTitle()
                .toLowerCase()
                .contains("neysa"));
    }
}
