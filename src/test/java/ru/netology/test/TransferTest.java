package ru.netology.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.DashboardPage;
import ru.netology.page.TransferPage;

import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {
    DataHelper user;
    DashboardPage dashboardPage;

    @BeforeEach
    public void auth() {
        open("http://localhost:9999/");
        LoginPage login = new LoginPage();
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = login.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    public void transfer100() {
        TransferPage transferPage = dashboardPage.chooseCardTo(0);
        transferPage.transfer( 100, "5559 0000 0000 0002");

       int cardToBalance = dashboardPage.getBalance(0);
       int cardFromBalance = dashboardPage.getBalance(1);

       int cardToExpectedBalance = 10100;
       int cardFromExpectedBalance = 9900;

       assertEquals(cardToExpectedBalance, cardToBalance );
       assertEquals(cardFromExpectedBalance, cardFromBalance);

      //  dashboardPage.chooseCardTo(1);
      //  transferPage.transfer(user, 100, 0);
      //  dashboardPage.assertBalance(0, 10000);
      //  dashboardPage.assertBalance(1, 10000);


    }

}
