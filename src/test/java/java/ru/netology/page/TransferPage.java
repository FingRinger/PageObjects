package java.ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement sum = $("[data-test-id='amount'] .input__inner");
    private SelenideElement from = $("[data-test-id='from'] .input__inner");
    private SelenideElement topUp = $("[data-test-id ='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id ='action-cancel']");
//private SelenideElement errorNotification

    public void transfer (DataHelper user, int amount, int indexCardFrom) {
        sum.setValue(String.valueOf(amount));
        from.setValue(user.getCard(indexCardFrom));
        topUp.click();
        //  errorNotification.should(hidden);

    }
}
