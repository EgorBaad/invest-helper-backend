package com.wellnow.investhelper.adapter.tinkoff;

import com.wellnow.investhelper.app.api.account.GetAccountsOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

import java.util.List;

@Component
@Slf4j
public class AccountAdapter implements GetAccountsOutbound {
    private InvestApi api;

    @Override
    public List<Account> getAccounts(String token) throws InvalidTokenException, InvalidApiRequestException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        try {
            return api.getUserService().getAccountsSync();
        } catch (ApiRuntimeException e) {
            throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
        } finally {
            log.info("AccountAdapter for Account adapter run");
            api.destroy(3);
        }
    }
}
