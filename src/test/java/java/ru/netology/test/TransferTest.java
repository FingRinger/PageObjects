package java.ru.netology.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.ru.netology.data.DataHelper;
import java.ru.netology.page.DashboardPage;
import java.ru.netology.page.LoginPage;
import java.ru.netology.page.TransferPage;
import java.ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class TransferTest {
    DataHelper user;
    DashboardPage dashboardPage;

    @BeforeEach
    public void auth() {
        open("http://localhost:9999/");
        LoginPage login = new LoginPage();
        user = new DataHelper();
        VerificationPage verificationPage = login.validLogin(user);
        dashboardPage = verificationPage.validVerify(user);
    }

    @Test
    public void transfer100() {
        TransferPage transferPage = dashboardPage.chooseCardTo(0);
        transferPage.transfer(user, 100, 1);
        dashboardPage.assertBalance(0, 10_100);
        dashboardPage.assertBalance(1, 9_900);

        dashboardPage.chooseCardTo(1);
        transferPage.transfer(user, 100, 0);
        dashboardPage.assertBalance(0, 10_000);
        dashboardPage.assertBalance(1, 10_000);


    }

}
