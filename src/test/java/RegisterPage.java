import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

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
    private final SelenideElement headerAccountLinkConstructor(String accountName){
        return $(By.xpath("//a[@href='/customer/info'][text()='"+accountName+"']"));
    }

    public void registerNewUser(String genderType, String firstName, String lastName, String email, String password, String confirmPassword){

        registerHeader.should(appear);
        if (genderType.equals("M")){
            genderMaleCheckbox.selectRadio(genderType);
        }
        if (genderType.equals("F")){
            genderFemaleCheckbox.selectRadio(genderType);
        }
        firstNameInput.type(firstName);
        lastNameInput.type(lastName);
        emailInput.type(email);
        passwordInput.type(password);
        confirmPasswordInput.type(confirmPassword);
        registerButton.click();
        registrationCompletedText.should(appear);
        continueButton.should(appear);
        headerAccountLinkConstructor(email).should(appear);
    }

    public void clickOnContinueAfterRegister(){
        continueButton.click();
        registerHeader.should(disappear);
    }
}
