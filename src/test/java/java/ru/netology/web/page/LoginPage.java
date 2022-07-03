package java.ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import java.ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement fieldLogin = $("[data-test-id=login] input");
    private SelenideElement fieldPassword = $("[data-test-id=password] input");
    private SelenideElement continueButton =  $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper user) {
      fieldLogin .setValue(user.getLogin());
      fieldPassword.setValue(user.getPassword());
      continueButton.click();
        return new VerificationPage();
    }

}