package com.wellnow.investhelper.domain;

public class Token {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String inToken) {
        token = inToken;
    }
}
