package com.wellnow.investhelper.app.impl.portfolio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.portfolio.GetPortfolioInbound;
import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;
import com.wellnow.investhelper.domain.DBond;
import com.wellnow.investhelper.domain.DPortfolio;
import com.wellnow.investhelper.domain.DPosition;
import com.wellnow.investhelper.domain.DShare;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.core.models.Portfolio;
import ru.tinkoff.piapi.core.models.Position;

@Component
@RequiredArgsConstructor
public class GetPortfolioUseCase implements GetPortfolioInbound {
    private final GetPortfolioOutbound getPortfolioOutbound;
    private final GetShareByFigiInbound getShareByFigiInbound;
    private final GetBondByFigiInbound getBondByFigiInbound;

    @Override
    public DPortfolio execute(String accountId) {
        Portfolio portfolio = getPortfolioOutbound.getPortfolio(accountId);
        Map<DShare, DPosition> shareList = new HashMap<DShare,DPosition>();
        Map<DBond, DPosition> bondList = new HashMap<DBond, DPosition>();
        for (Position position : portfolio.getPositions()) {
            switch (position.getInstrumentType()) {
                case "share": {
                    DShare share = getShareByFigiInbound.execute(position.getFigi());
                    if (share != null) {
                        shareList.put(share, new DPosition(position));
                    }
                    break;
                }
                case "bond": {
                    DBond bond = getBondByFigiInbound.execute(position.getFigi());
                    if (bond != null) {
                        bondList.put(bond, new DPosition(position));
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return new DPortfolio(portfolio, shareList, bondList);
    }
}
