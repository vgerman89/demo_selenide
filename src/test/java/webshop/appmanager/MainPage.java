package webshop.appmanager;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends HelperBase {

    public MainPage(WebDriverManager wdm){
        super (wdm);
    }

    private final SelenideElement registerLink = $("a.ico-register");

    public MainPage openMainPage(String url){
        open(url);
        return new MainPage(wdm);
    }

    public RegisterPage clickOnRegisterUrl(){
        registerLink.should(appear);
        registerLink.click();
        return new RegisterPage(wdm);
    }
}
