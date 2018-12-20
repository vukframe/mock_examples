package rs.edu.raf.mock_examples.selenium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManger {
    private static String GRID_BROWSER = "chrome";

    public DesiredCapabilities getCapabilities() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability("browserName", GRID_BROWSER);

        return capabilities;
    }

}
