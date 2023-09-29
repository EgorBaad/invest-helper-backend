package com.wellnow.investhelper.app.api.portfolio;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.core.models.Portfolio;

public interface GetPortfolioOutbound {
    public Portfolio getPortfolio(String token, String accountId)
            throws InvalidTokenException, InvalidApiRequestException;
}
