package java.ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import java.ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyContinueButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper user) {
    codeField.setValue(user.getVerificationCode());
    verifyContinueButton.click();
    return new DashboardPage();
    }
}
