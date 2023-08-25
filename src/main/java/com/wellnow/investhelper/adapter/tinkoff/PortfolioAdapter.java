package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.domain.Token;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.models.Portfolio;

@Component
@RequiredArgsConstructor
public class PortfolioAdapter implements GetPortfolioOutbound {
    private InvestApi api;

    public void init() {
        api = InvestApi.create(Token.getToken());
    }

    @Override
    public Portfolio getPortfolio(String accountId) {
        init();
        return api.getOperationsService().getPortfolioSync(accountId);
    }
}
