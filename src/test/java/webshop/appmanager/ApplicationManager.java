package webshop.appmanager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.Browser;

public class ApplicationManager {
    WebDriverManager wdm;

    private MainPage mainPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Не уверен что в случае селенида, нужно в хелперы прокидывать вебдрайвер, но пусть будет, для поддержки нативных средств селениума
        mainPage = new MainPage(wdm);
        registerPage = new RegisterPage(wdm);
        loginPage = new LoginPage(wdm);
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
    public LoginPage loginPage() {return loginPage;}
}
