package webshop.appmanager;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static webshop.appmanager.ConfigProvider.config;

public class MainPage extends HelperBase {

    public MainPage(WebDriverManager wdm){
        super (wdm);
    }

    private final SelenideElement registerLink = $("a.ico-register");

    private final String base_url = config.getString("app_url");

    public MainPage openMainPage(){
        open(base_url);
        return new MainPage(wdm);
    }

    public RegisterPage clickOnRegisterUrl(){
        registerLink.should(appear);
        registerLink.click();
        return new RegisterPage(wdm);
    }
}
