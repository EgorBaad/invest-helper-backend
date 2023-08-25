package com.wellnow.investhelper.domain;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.core.models.Portfolio;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DPortfolio {
    DMoneyValue totalAmount;
    Map<DShare,DPosition> sharePositions;
    Map<DBond,DPosition> bondPositions;

    public DPortfolio (Portfolio portfolio) {
        this.totalAmount = new DMoneyValue(portfolio.getTotalAmountPortfolio());
    }

    public DPortfolio(Portfolio portfolio, Map<DShare, DPosition> shareList, Map<DBond, DPosition> bondList) {
        this.totalAmount = new DMoneyValue(portfolio.getTotalAmountPortfolio());
        this.sharePositions = shareList;
        this.bondPositions = bondList;
    }
}
