package com.wellnow.investhelper.app.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.account.GetAccountsInbound;
import com.wellnow.investhelper.app.api.account.GetAccountsOutbound;
import com.wellnow.investhelper.domain.DAccount;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.Account;

@Component
@RequiredArgsConstructor
public class GetAccountsUseCase implements GetAccountsInbound {
    private final GetAccountsOutbound getAccountsOutbound;

    @Override
    public List<DAccount> execute(String token) {
        List<Account> accountList = getAccountsOutbound.getAccounts(token);
        List<DAccount> dAccountList = new ArrayList<>();
        for (Account account : accountList) {
            DAccount dAccount = new DAccount(account);
            dAccountList.add(dAccount);
        }

        return dAccountList;
    }
}
