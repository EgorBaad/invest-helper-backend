package com.wellnow.investhelper.app.api.portfolio;

import ru.tinkoff.piapi.core.models.Portfolio;

public interface GetPortfolioOutbound {
    public Portfolio getPortfolio(String token, String accountId);
}
