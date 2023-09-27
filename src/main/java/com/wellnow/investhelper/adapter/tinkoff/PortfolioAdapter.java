package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.models.Portfolio;

@Component
@RequiredArgsConstructor
public class PortfolioAdapter implements GetPortfolioOutbound {
    private InvestApi api;

    public void init(String token) {
        if (token != null) {api = InvestApi.create(token);}
    }

    @Override
    public Portfolio getPortfolio(String token, String accountId) {
        init(token);
        return api.getOperationsService().getPortfolioSync(accountId);
    }
}
