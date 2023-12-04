package webshop.appmanager;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends HelperBase {

    public LoginPage(WebDriverManager wdm) {
        super(wdm);
    }

    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement loginButton = $(By.xpath("//input[@class='button-1 login-button']"));

    @Step("Заполняем форму авторизации и жмем кнопку логин")
    public MainPage login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
        return new MainPage(wdm);
    }
}
