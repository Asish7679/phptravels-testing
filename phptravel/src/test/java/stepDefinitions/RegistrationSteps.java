package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private WebDriver driver;
    private RegistrationPage regPage;

    @When("user navigates to Sign Up page")
    public void user_navigates_to_signup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/signup"); 
        regPage = new RegistrationPage(driver);
    }

    @When("user enters registration details {string} {string} {string} {string} {string} {string}")
    public void user_enters_registration_details(String fname, String lname, String country, String phone, String email, String password) {
        if (email.contains("<time>")) {
            email = email.replace("<time>", String.valueOf(System.currentTimeMillis()));
        }

        regPage.enterFirstName(fname)
               .enterLastName(lname)
               .selectCountry(country)
               .enterPhone(phone)
               .enterEmail(email)
               .enterPassword(password);
    }

    @When("clicks on Sign Up button")
    public void user_clicks_signup() throws InterruptedException {
        regPage.clickSignUp();

        // Pause so you can manually solve CAPTCHA
        System.out.println("⚠ Please solve the CAPTCHA manually within 20 seconds...");
        Thread.sleep(20000);
    }

    @Then("account should be created successfully")
    public void account_created() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("success")) {
            System.out.println("✅ User registered successfully!");
        } else {
            throw new AssertionError("❌ Registration failed. Current URL: " + currentUrl);
        }
        driver.quit();
    }
}
