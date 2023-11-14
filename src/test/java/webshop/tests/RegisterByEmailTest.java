package webshop.tests;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterByEmailTest extends BaseTest {

    private final static String BASE_URL = "https://demowebshop.tricentis.com";
    private final static String GENDER = "M";
    private final static String FIRSTNAME = "FirstName";
    private final static String LASTNAME = "LastName";
    private final static String EMAIL = "mail"+RandomStringUtils.randomNumeric(3) + "@example.com";
    private final static String PASSWORD = "123456";

    @Test
    public void authByEmailTest(){

        app.mainPage
                .openMainPage(BASE_URL)
                .clickOnRegisterUrl()
                .registerNewUser(GENDER, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PASSWORD)
                .clickOnContinueAfterRegister();
    }


}
