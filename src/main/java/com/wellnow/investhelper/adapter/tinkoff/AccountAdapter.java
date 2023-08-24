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
        api = InvestApi.create(token);
    }

    @Override
    public List<Account> getAccounts() {
        init("t.iz5SOvygTW_963zXjxFk49EIYtV7gI_DHUif9_LbhyYkZCMyI1T-_njdnYJR4nW6HmluZdFijfreDJj8snVW1w");
        return api.getUserService().getAccountsSync();
    }
}
