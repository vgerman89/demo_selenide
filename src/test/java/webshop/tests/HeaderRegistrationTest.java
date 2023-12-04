package webshop.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;


public class HeaderRegistrationTest extends BaseTest {

    private final static String GENDER = "M";
    private final static String FIRSTNAME = "FirstName";
    private final static String LASTNAME = "LastName";
    private final static String EMAIL = "mail"+RandomStringUtils.randomNumeric(3) + "@example.com";
    private final static String PASSWORD = "123456";

    @Test
    @DisplayName("Registration positive test")
    @Owner("Vitaliy German")
    @Description("Выполняем тест успешной регистрации")
    public void PositiveRegistrationTest(){

        app.mainPage()
                .openMainPage()
                .clickOnRegisterLink()
                .registerNewUser(GENDER, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PASSWORD)
                .clickOnContinueAfterRegister();
    }
}
