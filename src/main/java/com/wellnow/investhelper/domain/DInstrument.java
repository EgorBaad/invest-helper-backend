package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.InstrumentShort;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DInstrument {
    String figi;
    String ticker;
    String name;
    String currency;
    String country;
    Integer lot;
    String type;
    Boolean qualOnly;

    public DInstrument(InstrumentShort instrument) {
        this.figi = instrument.getFigi();
        this.ticker = instrument.getTicker();
        this.name = instrument.getName();
        this.type = instrument.getInstrumentType();
    }
}
