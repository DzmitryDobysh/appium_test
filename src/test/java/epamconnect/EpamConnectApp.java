package epamconnect;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import spec.BaseSpec;

public class EpamConnectApp extends BaseSpec {

    private static final String[] DEFAULT_BUTTONS_TO_CLICK = {"Next", "Let's start"};

    public EpamConnectApp(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickButtons(String[] accessibilityIds) {
        for (String accessibilityId : accessibilityIds) {
            while (true) {
                try {
                    WebElement button = wait.until(
                            ExpectedConditions.presenceOfElementLocated(
                                    AppiumBy.accessibilityId(accessibilityId)));
                    button.click();
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

    public void clickDefaultButtons() {
        clickButtons(DEFAULT_BUTTONS_TO_CLICK);
    }

    public EpamConnectApp openAndClickDefaultButtons() {
        clickDefaultButtons();
        return this;
    }



    public EpamConnectApp clickSignUp() {
        WebElement signUpElement = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Sign Up")
        ));
        signUpElement.click();
        return this;
    }

    public EpamConnectApp switchToWebView() {
        driver.context("WEBVIEW_chrome");
        return this;
    }

    public EpamConnectApp enterUsername(String username) {
        WebElement usernameElement = waitForElementVisible(AppiumBy.id("username"));
        usernameElement.sendKeys(username);
        return this;
    }

    public EpamConnectApp clickContinueButtonStep1() {
        WebElement continueButtonStep1 = driver.findElement(AppiumBy.id("kc-login-next"));
        continueButtonStep1.click();
        return this;
    }

    public EpamConnectApp enterFirstName(String firstName) {
        WebElement firstNameElement = waitForElementVisible(AppiumBy.id("firstName"));
        firstNameElement.sendKeys(firstName);
        return this;
    }

    public EpamConnectApp enterPassword(String password) {
        WebElement passwordElement = driver.findElement(AppiumBy.id("password"));
        passwordElement.sendKeys(password);
        return this;
    }

    public EpamConnectApp enterPasswordConfirm(String password) {
        WebElement passwordConfirmElement = waitForElementVisible(AppiumBy.id("password-confirm"));
        passwordConfirmElement.sendKeys(password);
        return this;
    }

    public EpamConnectApp clickContinueButtonStep2() {
        WebElement continueButtonStep2 = waitForElementVisible(AppiumBy.id("kc-login-step2"));
        continueButtonStep2.click();
        return this;
    }

    public void verifyLocationText(String expectedLocationText) {
        WebElement locationText = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.id("header3")));
        wait.until(ExpectedConditions.visibilityOf(locationText));
        String actualText = locationText.getText();
        assert (actualText.contains(expectedLocationText));
        if (actualText.contains(expectedLocationText)) {
            System.out.println("Text matches: " + actualText);
        } else {
            System.err.println("Text doesn't match: " + actualText);
        }
    }
}
