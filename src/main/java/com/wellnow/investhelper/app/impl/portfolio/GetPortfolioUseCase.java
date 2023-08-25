package com.wellnow.investhelper.app.impl.portfolio;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioInbound;
import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.domain.DPortfolio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetPortfolioUseCase implements GetPortfolioInbound {
    private final GetPortfolioOutbound getPortfolioOutbound;

    @Override
    public DPortfolio execute(String accountId) {
        return new DPortfolio(getPortfolioOutbound.getPortfolio(accountId));
    }
}
