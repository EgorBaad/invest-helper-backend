package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.account.GetAccountsOutbound;

import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class AccountAdapter implements GetAccountsOutbound {
    private InvestApi api;

    public void init(String token) {
        if (token != null) {api = InvestApi.create(token);}
    }

    @Override
    public List<Account> getAccounts(String token) {
        init(token);
        return api.getUserService().getAccountsSync();
    }
}
