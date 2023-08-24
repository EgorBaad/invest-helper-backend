package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.account.GetAccountsOutbound;
import com.wellnow.investhelper.domain.Token;

import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class AccountAdapter implements GetAccountsOutbound {
    private InvestApi api;

    public void init() {
        api = InvestApi.create(Token.getToken());
    }

    @Override
    public List<Account> getAccounts() {
        init();
        return api.getUserService().getAccountsSync();
    }
}
