package ru.netology.data;

import lombok.Data;
import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password ;
        private String[] cards = new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"};
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya","qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
}

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo){
        return new VerificationCode("12345");
}


     //   public String getCard(int index) {
     //       String card = cards[index];
     //       return card;
     //   }
    }
