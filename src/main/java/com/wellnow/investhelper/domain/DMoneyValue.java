package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.MoneyValue;
import ru.tinkoff.piapi.core.models.Money;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DMoneyValue {
    String currency;
    Double value;

    public DMoneyValue(MoneyValue mv) {
        this.currency = mv.getCurrency();
        this.value = mv.getUnits() + (mv.getNano() / Math.pow(10, String.valueOf(mv.getNano()).length()));
    }

    public DMoneyValue(Money money) {
        this.currency = money.getCurrency();
        this.value = money.getValue().doubleValue();
    }
}
