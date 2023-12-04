package webshop.appmanager;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.security.AuthProvider;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static webshop.appmanager.ConfigProvider.config;

public class MainPage extends HelperBase {

    public MainPage(WebDriverManager wdm){
        super (wdm);
    }

    private final String base_url = config.getString("app_url");

    private final SelenideElement registerLink = $("a.ico-register");
    private final SelenideElement loginLink = $("a.ico-login");
    private final SelenideElement accountLink = $(By.xpath("//a[@href='/customer/info']"));


    @Step("Открываем главную страницу")
    public MainPage openMainPage(){
        open(base_url);
        return new MainPage(wdm);
    }

    @Step("Нажимаем на ссылку регистрации в хэдере")
    public RegisterPage clickOnRegisterLink(){
        registerLink.should(appear);
        registerLink.click();
        return new RegisterPage(wdm);
    }

    @Step("Нажимаем на ссылку авторизации в хэдере")
    public LoginPage clickOnLoginLink() {
        loginLink.should(appear);
        loginLink.click();
        return new LoginPage(wdm);
    }
    @Step("Забираем текст из ссылки на личный кабинет")
    public String getAccountLinkText() {
        return accountLink.getText();
    }
}
