package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private By searchBar = new By.ByName("q");
    private By button = new By.ByName("btnK");

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertQueryInSearchBar(String query) {
        driver.findElement(searchBar).sendKeys(query);
    }

    public SearchResultPage clickSearchButton() {
        driver.findElement(button).submit();
        return new SearchResultPage(driver);
    }
}
