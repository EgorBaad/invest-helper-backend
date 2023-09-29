package com.wellnow.investhelper.app.api.account;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DAccount;

public interface GetAccountsInbound {
    public List<DAccount> execute(String token) throws InvalidTokenException, InvalidApiRequestException;
}
