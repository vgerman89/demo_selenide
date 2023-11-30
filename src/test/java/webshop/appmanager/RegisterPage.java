package webshop.appmanager;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends HelperBase {

    public RegisterPage(WebDriverManager wdm){
        super (wdm);
    }

    private final SelenideElement registerHeader =$(By.xpath("//h1[text()='Register']"));
    private final SelenideElement genderMaleCheckbox = $("input#gender-male");
    private final SelenideElement genderFemaleCheckbox = $("input#gender-female");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement registerButton = $("input#register-button");
    private final SelenideElement registrationCompletedText = $(By.xpath("//div[@class='result'][text()='\n" +
            "            Your registration completed\n" +
            "        ']"));
    private final SelenideElement continueButton = $("input.button-1.register-continue-button");
    private SelenideElement headerAccountLinkConstructor(String accountName){
        return $(By.xpath("//a[@href='/customer/info'][text()='"+accountName+"']"));
    }

    public RegisterPage registerNewUser(String genderType, String firstName, String lastName, String email, String password, String confirmPassword){

        registerHeader.should(appear);
        if (genderType.equals("M")){
            genderMaleCheckbox.selectRadio(genderType);
        }
        if (genderType.equals("F")){
            genderFemaleCheckbox.selectRadio(genderType);
        }
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(confirmPassword);
        registerButton.click();
        registrationCompletedText.should(appear);
        continueButton.should(appear);
        headerAccountLinkConstructor(email).should(appear);
        return new RegisterPage(wdm);
    }

    public void clickOnContinueAfterRegister(){
        continueButton.click();
        registerHeader.should(disappear);
    }
}
