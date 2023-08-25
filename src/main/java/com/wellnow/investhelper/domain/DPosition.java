package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.core.models.Position;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DPosition {
    String figi;
    Double quantity;
    String type;
    DMoneyValue avgPrice;
    DMoneyValue currentPrice;

    public DPosition(Position position) {
        this.figi = position.getFigi();
        this.type = position.getInstrumentType();
        this.quantity = position.getQuantity().doubleValue();
        this.avgPrice = new DMoneyValue(position.getAveragePositionPrice());
        this.currentPrice = new DMoneyValue(position.getCurrentPrice());
    }
}
