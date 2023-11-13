import org.junit.jupiter.api.Test;

public class RegisterByEmailTest extends BaseTest {

    private final static String BASE_URL = "https://demowebshop.tricentis.com";
    private final static String GENDER = "M";
    private final static String FIRSTNAME = "FirstName";
    private final static String LASTNAME = "LastName";
    //TODO прикрутить рандомизатор email
    private final static String EMAIL = "test11223221@example.com";
    private final static String PASSWORD = "123456";

    @Test
    public void authByEmailTest(){
        MainPage mainPage = new MainPage();
        RegisterPage registerPage = new RegisterPage();

        mainPage.openMainPage(BASE_URL);
        mainPage.clickOnRegisterUrl();
        registerPage.registerNewUser(GENDER, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PASSWORD);
        registerPage.clickOnContinueAfterRegister();
    }


}
