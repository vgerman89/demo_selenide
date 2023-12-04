package webshop.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeaderLoginTest extends BaseTest {

    private final static String EMAIL = "demo_selenide@somewhere.com";
    private final static String PASSWORD = "123456";


    @Test
    @DisplayName("Login positive test")
    @Owner("Vitaliy German")
    @Description("Выполняем тест успешной авторизации")
    public void PositiveLoginTest() {

        app.mainPage()
                .openMainPage()
                .clickOnLoginLink()
                .login(EMAIL, PASSWORD);

        String accountName = app.mainPage().getAccountLinkText();
        Assertions.assertEquals(accountName, EMAIL);
    }
}
