package rs.edu.raf.mock_examples.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoSelenium {

    private static Integer DEFAULT_WAIT_TIME = 10;

    @Test
    public void seleniumDemo() throws Exception {
//
//        RemoteDriverManager remoteDriverManager = new RemoteDriverManager();
//        remoteDriverManager.createDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability("takesScreenshot", true);
//        capabilities.setCapability("browserName", "chrome");

//        WebDriver driver = new ChromeDriver();
//        WebDriver driver = remoteDriverManager.getDriver();

        // Pretrazujemo google stranicu


        System.setProperty("webdriver.chrome.driver","C:\\Users\\vukg\\Downloads\\testiranje-faks\\mock-examples\\src\\test\\resources" +
                                                     "\\chromedriver.exe");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");

////        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setVersion("69.0.3497");
//        capabilities.setVersion("69.0.3497");
////        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setPlatform(Platform.WIN10);
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        DesiredCapabilities capability = DesiredCapabilities.chrome();

        WebDriver driver = new RemoteWebDriver(new URL("http://172.18.53.65:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        Thread.sleep(5000);
        // Alternativni nacin
        // driver.navigate().to("http://www.google.com");

        // Nalazimo element na stranici sa imenom q+
        WebElement element = driver.findElement(By.name("q"));
        // driver.findElement(By.id("coolestWidgetEvah"));
        // List<WebElement> cheeses = driver.findElements(By.className("cheese"));
        // WebElement cheese = driver.findElement(By.linkText("cheese"));

        // Unosimo tekst u pretragu
        element.sendKeys("Cheese!");

        Thread.sleep(5000);

        // Nakon unetog teksta izvrsavamo submit na formi
        element.submit();

        // Provera imena stranice
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();

    }
}
