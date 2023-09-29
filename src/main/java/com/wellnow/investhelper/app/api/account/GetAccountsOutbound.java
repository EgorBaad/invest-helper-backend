package com.wellnow.investhelper.app.api.account;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Account;

public interface GetAccountsOutbound {
    public List<Account> getAccounts(String token) throws InvalidTokenException, InvalidApiRequestException;
}
