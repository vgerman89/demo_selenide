package webshop.appmanager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.Browser;

public class ApplicationManager {
    WebDriverManager wdm;

    public MainPage mainPage;
    public RegisterPage registerPage;
    private String browser;
    public ApplicationManager(String browser){
        this.browser = browser;
    }

    public void setUp(){
        if (browser.equals(Browser.CHROME.browserName())){
            wdm = WebDriverManager.chromedriver();
        }

        //Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

        mainPage = new MainPage(wdm);
        registerPage = new RegisterPage(wdm);
    }

    public void stop() {
        Selenide.closeWebDriver();
    }

    public MainPage mainPage() {
        return mainPage;
    }

    public RegisterPage registerPage(){
        return registerPage;
    }
}
