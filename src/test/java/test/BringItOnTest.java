package test;

import epamconnect.EpamConnectApp;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;


public class BringItOnTest extends BaseSpec {


    private static final String USERNAME = "Lorem@test.example.com";
    private static final String FIRSTNAME = "Myname";
    private static final String PASSWORD = "Ipsum1234";
    private static final String expectedLocationText = "Your location";


    @Test
    public void test() {
        EpamConnectApp epamConnectApp = new EpamConnectApp(driver, wait);
        epamConnectApp
                .openAndClickDefaultButtons()
                .clickSignUp()
                .switchToWebView()
                .enterUsername(USERNAME)
                .clickContinueButtonStep1()
                .enterFirstName(FIRSTNAME)
                .enterPassword(PASSWORD)
                .enterPasswordConfirm(PASSWORD)
                .clickContinueButtonStep2()
                .verifyLocationText(expectedLocationText);
    }
}