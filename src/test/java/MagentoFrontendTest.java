import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.magento.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MagentoFrontendTest {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver.exe");
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
        MagentoHomePage homePage = new MagentoHomePage(driver);
        homePage.clickCreateAnAccount();

        CreateAccountPage create = new CreateAccountPage(driver);
        create.setFirstName("kelompok");
        create.setLastName("testing");
        create.clickSubscribe();
        create.setEmail("rafidrayhaneros2@gmail.com");
        create.setPassword("Bismillahselesai123");
        create.setConfirmPassword("Bismillahselesai123");
        create.clickCreateAccount();
        MagentoMyAccountPage success = new MagentoMyAccountPage(driver);
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", driver.getCurrentUrl());
    }

    @Test
    public void testLogin() {
        // Rayhan
        MagentoHomePage homePage = new MagentoHomePage(driver);
        MagentoLoginPage loginPage = homePage.clickLoginButton();
        MagentoMyAccountPage myAccountPage = loginPage.login("rafidrayhaneros@gmail.com", "Bismillahselesai123");
        assertEquals("https://magento.softwaretestingboard.com/", driver.getCurrentUrl());
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
        HomeMagentoPage h1 = new HomeMagentoPage(driver);
        JacketPage j1 = h1.clickJacketOps();
        DetailJacketPage d1 = j1.selectJacket1();
        // Menambahkan item 1 ke Cart
        d1.selectSizeJacket1();
        d1.selectColorJacket1();
        d1.addToCart();
        // Menambahkan item 2 ke Cart
        h1.clickJacketOps();
        j1.selectJacket2();
        d1.selectSizeJacket2();
        d1.selectColorJacket2();
        d1.addToCart();

    }

    @Test
    public void testCheckout() {
        // Eros
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        HomeMagentoPage h1 = new HomeMagentoPage(driver);
        JacketPage j1 = h1.clickJacketOps();
        DetailJacketPage d1 = j1.selectJacket1();
        // Menambahkan item 1 ke Cart
        d1.selectSizeJacket1();
        d1.selectColorJacket1();
        d1.addToCart();
        // Menambahkan item 2 ke Cart
        h1.clickJacketOps();
        j1.selectJacket2();
        d1.selectSizeJacket2();
        d1.selectColorJacket2();
        d1.addToCart();
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        ShippingPage ship1 = d1.checkCart();
        ship1.setShippingtxt(
                "Rockys@gmai.com",
                "Rocky",
                "gerger",
                "Jl.Burung unta",
                "Jakarta",
                "55745",
                "083524715014"
        );
        ship1.setStateProv_country_shipM1();
        ship1.nextBtn();

    }

    @Test
    public void testOrderSummary() {
        // Eros
        // Membuka halaman produk dengan mengklik produk yang ada di Men
        HomeMagentoPage h1 = new HomeMagentoPage(driver);
        JacketPage j1 = h1.clickJacketOps();
        DetailJacketPage d1 = j1.selectJacket1();
        // Menambahkan item 1 ke Cart
        d1.selectSizeJacket1();
        d1.selectColorJacket1();
        d1.addToCart();
        // Menambahkan item 2 ke Cart
        h1.clickJacketOps();
        j1.selectJacket2();
        d1.selectSizeJacket2();
        d1.selectColorJacket2();
        d1.addToCart();
        // Membuka Cart lalu Proceed to checkout (pastikan itemnya sama dengan yang kita pilih di cart)
        ShippingPage ship1 = d1.checkCart();
        ship1.setShippingtxt(
                "Rockys@gmai.com",
                "Rocky",
                "gerger",
                "Jl.Burung unta",
                "Jakarta",
                "55745",
                "083524715014"
        );
        ship1.setStateProv_country_shipM1();
        TransPage trnsO1 = ship1.nextBtn();
        // Memastikan order summary sudah sama
        Assert.assertEquals("Order Summary\n" +
                "2 Items in Cart\n" +
                "Proteus Fitness Jackshirt\n" +
                "Qty 1\n" +
                "$45.00\n" +
                "View Details\n" +
                "Jupiter All-Weather Trainer\n" +
                "Qty 1\n" +
                "$56.99\n" +
                "View Details",trnsO1.getOrderSummary());

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
        MagentoHomePage homePage = new MagentoHomePage(driver);
        MagentoLoginPage loginPage = homePage.clickLoginButton();
        MagentoMyAccountPage myAccountPage = loginPage.login("rafidrayhaneros@gmail.com", "Bismillahselesai123");
        myAccountPage.clickLogoutButton();
        assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", driver.getCurrentUrl());
    }
}
