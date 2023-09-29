package com.wellnow.investhelper.app.api.portfolio;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DPortfolio;

public interface GetPortfolioInbound {
    public DPortfolio execute(String token, String accountId) throws InvalidTokenException, InvalidApiRequestException;
}
