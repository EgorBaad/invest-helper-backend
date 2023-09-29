package com.wellnow.investhelper.app.impl.portfolio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.portfolio.GetPortfolioInbound;
import com.wellnow.investhelper.app.api.portfolio.GetPortfolioOutbound;
import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
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
    public DPortfolio execute(String token, String accountId) throws InvalidTokenException, InvalidApiRequestException {
        Portfolio portfolio = getPortfolioOutbound.getPortfolio(token, accountId);
        List<DPosition> positionList = new ArrayList<>();
        for (Position position : portfolio.getPositions()) {
            switch (position.getInstrumentType()) {
                case "share": {
                    DShare share = getShareByFigiInbound.execute(token, position.getFigi());
                    if (share != null) {
                        positionList.add(new DPosition(position, share));
                    }
                    break;
                }
                case "bond": {
                    DBond bond = getBondByFigiInbound.execute(token, position.getFigi());
                    if (bond != null) {
                        positionList.add(new DPosition(position, bond));
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return new DPortfolio(portfolio, positionList);
    }
}
