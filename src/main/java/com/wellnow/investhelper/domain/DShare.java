package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.Share;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DShare {
    String figi;
    String name;
    String ticker;
    String currency;
    String country;

    public DShare(Share share) {
        this.figi = share.getFigi();
        this.name = share.getName();
        this.ticker = share.getTicker();
        this.currency = share.getCurrency();
        this.country = share.getCountryOfRisk();
    }
}
