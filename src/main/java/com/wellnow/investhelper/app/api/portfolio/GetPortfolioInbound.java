package com.wellnow.investhelper.app.api.portfolio;

import com.wellnow.investhelper.domain.DPortfolio;

public interface GetPortfolioInbound {
    public DPortfolio execute(String accountId);
}
