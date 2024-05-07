package com.wellnow.investhelper.adapter.tinkoff;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;
import ru.tinkoff.piapi.core.models.Portfolio;

@Component
@Slf4j
public class PortfolioAdapter implements GetPortfolioOutbound {
    InvestApi api;

    @Override
    public Portfolio getPortfolio(String token, String accountId)
            throws InvalidTokenException, InvalidApiRequestException {
        InvestApi api;
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        if (accountId != null && !accountId.isEmpty()) {
            try {
                return api.getOperationsService().getPortfolioSync(accountId);
            } catch (ApiRuntimeException e) {
                throw new InvalidApiRequestException("Invalid request: " + e.getMessage());
            } finally {
                log.info("PortfolioAdapter for Account adapter run");
                api.destroy(3);
            }
        } else {
            log.info("PortfolioAdapter for Account adapter run");
            api.destroy(3);
            throw new InvalidApiRequestException("Invalid request. Empty accountId.");
        }
    }
}
