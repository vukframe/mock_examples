package rs.edu.raf.mock_examples.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void createDriver() throws MalformedURLException;
    protected abstract WebDriverWait createWait();

    public WebDriver getDriver() throws MalformedURLException {

        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public WebDriverWait getWait() {

        return createWait();
    }

}
