import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement registerLink = $("a.ico-register");

    public void openMainPage(String url){
        open(url);
    }

    public void clickOnRegisterUrl(){
        registerLink.should(appear);
        registerLink.click();
    }
}
