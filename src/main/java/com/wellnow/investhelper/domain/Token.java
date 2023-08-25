package com.wellnow.investhelper.domain;

import ru.tinkoff.piapi.core.InvestApi;

public class Token {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static boolean setToken(String inToken) {
        token = inToken;
        try {
            InvestApi api = InvestApi.create(inToken);
            api.getInstrumentsService().getAllCurrenciesSync();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
