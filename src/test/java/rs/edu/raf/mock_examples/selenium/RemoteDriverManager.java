package rs.edu.raf.mock_examples.selenium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteDriverManager extends DriverManager {

    private static Integer DEFAULT_WAIT_TIME = 20;
    private static String GRID_URL = "http://localhost:4444/wd/hub";
    private DesiredCapabilities capabilities;

    public RemoteDriverManager() {
        CapabilitiesManger capabilitiesManger = new CapabilitiesManger();
        this.capabilities = capabilitiesManger.getCapabilities();
    }

    @Override
    public void createDriver() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @Override
    public WebDriverWait createWait() {

        return new WebDriverWait(driver, DEFAULT_WAIT_TIME);
    }

}
