package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.account.GetAccountsOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

@Component
public class AccountAdapter implements GetAccountsOutbound {
    @Override
    public List<Account> getAccounts(String token) throws InvalidTokenException, InvalidApiRequestException {
        InvestApi api;
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        try {
            return api.getUserService().getAccountsSync();
        } catch (ApiRuntimeException e) {
            throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
        }
    }
}
