import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.formyproject.FormyProjectCompleteFormPage;

public class FormyProjectTest {
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
        driver.get("https://formy-project.herokuapp.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFillForm() throws InterruptedException {
        driver.findElement(new By.ByLinkText("Complete Web Form"))
                .click();

        Thread.sleep(1000);

        FormyProjectCompleteFormPage formPage = new FormyProjectCompleteFormPage(driver);
        formPage.fillFirstNameField("Rafid");
        formPage.fillLastNameField("Aslam");
        formPage.fillJobTitleField("Software Engineer");
        formPage.selectMaleCheck();
        formPage.selectHighSchoolRadio();
        formPage.selectYearsOfExperience(4);
        formPage.fillDateField("20/12/2022");
        formPage.clickSubmitButton();

        // FIXME: When the form is faulty, the frontend will still redirect it to /thanks
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/thanks");
    }
}
