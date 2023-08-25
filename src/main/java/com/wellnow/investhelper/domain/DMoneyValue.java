package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.MoneyValue;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DMoneyValue {
    String currency;
    Long units;
    Integer nano;
    Double value;

    public DMoneyValue(MoneyValue mv) {
        this.currency = mv.getCurrency();
        this.units = mv.getUnits();
        this.nano = mv.getNano();
        this.value = this.units.doubleValue() + (this.nano / Math.pow(10, String.valueOf(this.nano).length()));
    }
}
