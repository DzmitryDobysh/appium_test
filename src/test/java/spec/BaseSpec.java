package spec;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseSpec {

    //Application stored locally due to issues with finding online sources
    private static final String APP = new File("src/test/resources/apks/EPAM_Connect_2.20.apk").getAbsolutePath();
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), capabilities);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
