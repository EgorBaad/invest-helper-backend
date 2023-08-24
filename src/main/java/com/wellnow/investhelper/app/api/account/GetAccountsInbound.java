package com.wellnow.investhelper.app.api.account;

import java.util.List;

import com.wellnow.investhelper.domain.DAccount;

public interface GetAccountsInbound {
    public List<DAccount> execute();
}
