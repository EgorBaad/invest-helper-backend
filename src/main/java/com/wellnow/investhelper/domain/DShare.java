package com.wellnow.investhelper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.Share;
import ru.tinkoff.piapi.core.models.Position;

@ToString
@Getter
@Setter
public class DShare extends DInstrument {
    public DShare(Share share) {
        this.figi = share.getFigi();
        this.name = share.getName();
        this.ticker = share.getTicker();
        this.currency = share.getCurrency();
        this.country = share.getCountryOfRisk();
    }

    public DShare(Position position) {
        this.figi = position.getFigi();
    }
}
