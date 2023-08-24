package com.wellnow.investhelper.app.impl.token;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.token.SetTokenInbound;
import com.wellnow.investhelper.domain.Token;

@Component
public class SetTokenUseCase implements SetTokenInbound {
    @Override
    public void execute(String token) {
        Token.setToken(token);
    }
}
