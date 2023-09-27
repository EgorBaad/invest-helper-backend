package com.wellnow.investhelper.app.impl.token;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.token.TestTokenInbound;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class TestTokenUseCase implements TestTokenInbound {
    @Override
    public boolean execute(String token) {
        if (token == null) return false;
        try {
            InvestApi api = InvestApi.create(token);
            api.getInstrumentsService().getAllCurrenciesSync();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
