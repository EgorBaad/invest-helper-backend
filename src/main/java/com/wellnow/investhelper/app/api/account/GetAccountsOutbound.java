package com.wellnow.investhelper.app.api.account;

import java.util.List;

import ru.tinkoff.piapi.contract.v1.Account;

public interface GetAccountsOutbound {
    public List<Account> getAccounts();
}
