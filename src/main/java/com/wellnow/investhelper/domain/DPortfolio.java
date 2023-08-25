package com.wellnow.investhelper.domain;

import java.util.List;

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
    List<DShare> shareList;

    public DPortfolio (Portfolio portfolio) {
        this.totalAmount = new DMoneyValue(portfolio.getTotalAmountPortfolio());
    }
}
