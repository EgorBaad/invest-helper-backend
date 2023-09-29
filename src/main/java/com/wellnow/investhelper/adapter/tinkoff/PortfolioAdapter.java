package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;
import ru.tinkoff.piapi.core.models.Portfolio;

@Component
@RequiredArgsConstructor
public class PortfolioAdapter implements GetPortfolioOutbound {
    @Override
    public Portfolio getPortfolio(String token, String accountId)
            throws InvalidTokenException, InvalidApiRequestException {
        InvestApi api;
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token " + token);
        }
        if (accountId != null && !accountId.equals("")) {
            try {
                return api.getOperationsService().getPortfolioSync(accountId);
            } catch (ApiRuntimeException e) {
                throw new InvalidApiRequestException("Invalid request: " + e.getMessage());
            }
        } else {
            throw new InvalidApiRequestException("Invalid request. Empty accountId.");
        }
    }
}
