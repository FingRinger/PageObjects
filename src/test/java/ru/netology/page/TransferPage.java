package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferPage {
    //private SelenideElement sum = $("[data-test-id='amount'] .input");
    private SelenideElement sum = $x(".//span[@data-test-id=\"amount\"]//input");
  //private SelenideElement from = $("[data-test-id='from'] .input");
    private SelenideElement from = $x(".//span[@data-test-id=\"from\"]//input");
    private SelenideElement topUp = $("[data-test-id ='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id ='action-cancel']");


    public void transfer (DataHelper user, int amount, int indexCardFrom) {
        sum.setValue(String.valueOf(amount));
        from.setValue(user.getCard(indexCardFrom));
        topUp.click();
    }
}
