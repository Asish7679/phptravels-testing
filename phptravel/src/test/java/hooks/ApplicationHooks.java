package hooks;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class ApplicationHooks {

    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;

    @Before
    public void launchBrowser() {
        configReader = new ConfigReader();
        prop = configReader.initProp();
        String browserName = prop.getProperty("browser");
        driver = DriverFactory.initDriver(browserName);
        driver.get(prop.getProperty("url"));
    }

    @After
    public void quitBrowser() {
        DriverFactory.quitDriver();
    }
}
