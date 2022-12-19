import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.magento.MagentoLoginPage;
import pages.saucedemo.SauceDemoLoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MagentoFrontendTest {
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
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreateAccount() {
        // Rayhan

    }

    @Test
    public void testLogin() {
        // Rayhan

    }

    @Test
    public void testSelectProduct() {
        // Rayhan
        // Membuka halaman produk dengan mengklik produk yang ada di Men
    }

    @Test
    public void testAddToCart() {
        // Eros
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        // Menambahkan ke Cart
    }

    @Test
    public void testCheckout() {
        // Eros
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        // Menambahkan ke Cart
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
    }

    @Test
    public void testOrderSummary() {
        // Eros
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        // Menambahkan ke Cart
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        // Memastikan order summary sudah sama
    }

    @Test
    public void testShippingAddress() {
        // Rafid
        // Membuka halaman produk dengan mengklik produk yang ada di Menu
        // Menambahkan ke Cart
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        // Membuka order summary
        // Mengisi shipping address
        // Next, lalu memastikan shipping address sudah sesuai
    }

    @Test
    public void testPlaceOrder() {
        // Rafid
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        // Menambahkan ke Cart
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        // Membuka order summary
        // Mengisi shipping address
        // Next
        // Pastikan yang kita order sama
        // Place Order
    }

    @Test
    public void testOrderIsTheSame() {
        // Rafid
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        // Menambahkan ke Cart
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        // Membuka order summary
        // Mengisi shipping address
        // Next >  Place Order
        // Membuka nomor order, lalu memastikan bahwa itemnya sama dengan yang kita order
    }

    @Test
    public void testLogout() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        MagentoLoginPage loginPage = new MagentoLoginPage(driver);
        loginPage.login("rafidrayhaneros@gmail.com", "Bismillahselesai123");
    }
}
