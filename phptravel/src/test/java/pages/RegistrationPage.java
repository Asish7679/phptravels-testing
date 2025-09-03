package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By countryDropdown = By.xpath("//*[@id=\"signup\"]/div/div/div/div[3]/div[1]/div/div/button/div/div/div"); 
    private By phoneField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signUpButton = By.id("signup");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage enterFirstName(String fname) {
        driver.findElement(firstNameField).sendKeys(fname);
        return this;
    }

    public RegistrationPage enterLastName(String lname) {
        driver.findElement(lastNameField).sendKeys(lname);
        return this;
    }

    public RegistrationPage selectCountry(String country) {
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText("India");
        return this;
    }

    public RegistrationPage enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }
}
