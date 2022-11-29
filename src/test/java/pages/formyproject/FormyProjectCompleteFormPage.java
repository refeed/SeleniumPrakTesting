package pages.formyproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormyProjectCompleteFormPage {
    private WebDriver driver;

    private By firstNameFieldBy = new By.ById("first-name");
    private By lastNameFieldBy = new By.ById("last-name");
    private By jobTitleFieldBy = new By.ById("job-title");
    private By highSchoolRadioBy = new By.ById("radio-button-1");
    private By collegeRadioBy = new By.ById("radio-button-2");
    private By gradSchoolRadioBy = new By.ById("radio-button-3");
    private By maleCheckBy = new By.ById("checkbox-1");
    private By femaleCheckBy = new By.ById("checkbox-2");
    private By preferNotToSayCheckBy = new By.ById("checkbox-3");
    private By yearsOfExperienceSelectBy = new By.ById("select-menu");
    private By datePickerBy = new By.ById("datepicker");
    private By submitButtonBy = new By.ByLinkText("Submit");

    public FormyProjectCompleteFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstNameField(String text) {
        driver.findElement(firstNameFieldBy).sendKeys(text);
    }

    public void fillLastNameField(String text) {
        driver.findElement(lastNameFieldBy).sendKeys(text);
    }

    public void fillJobTitleField(String text) {
        driver.findElement(jobTitleFieldBy).sendKeys(text);
    }

    public void fillDateField(String text) {
        driver.findElement(datePickerBy).sendKeys(text);
    }

    public void selectMaleCheck() {
        driver.findElement(maleCheckBy).click();
    }

    public void selectHighSchoolRadio() {
        driver.findElement(highSchoolRadioBy).click();
    }

    public void selectYearsOfExperience(int index) {
        // 1: 0-1
        // 2: 2-4
        // 3: 5-9
        // 4: 10
        Select yearsofExperienceDropdown = new Select(
                driver.findElement(yearsOfExperienceSelectBy)
        );
        yearsofExperienceDropdown.selectByIndex(index);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonBy).click();
    }
}
