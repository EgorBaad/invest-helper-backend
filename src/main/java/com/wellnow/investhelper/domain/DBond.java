package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.Bond;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DBond extends DInstrument {
    DMoneyValue nominal;

    public DBond(Bond bond) {
        this.figi = bond.getFigi();
        this.ticker = bond.getTicker();
        this.lot = bond.getLot();
        this.currency = bond.getCurrency();
        this.country = bond.getCountryOfRisk();
        this.name = bond.getName();
        this.nominal = new DMoneyValue(bond.getNominal());
    }
}
