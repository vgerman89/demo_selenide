package webshop.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.Browser;
import webshop.appmanager.ApplicationManager;

abstract public class BaseTest {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeEach
    public void init(){
        app.setUp();
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
