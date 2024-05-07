package com.wellnow.investhelper.domain;

import com.google.protobuf.Timestamp;
import lombok.*;
import ru.tinkoff.piapi.contract.v1.Candle;
import ru.tinkoff.piapi.contract.v1.HistoricCandle;

import java.time.Instant;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DCandle {
    DMoneyValue open;
    DMoneyValue close;
    DMoneyValue high;
    DMoneyValue low;
    Instant time;

    public DCandle(HistoricCandle c) {
        this.open = new DMoneyValue(c.getOpen());
        this.close = new DMoneyValue(c.getClose());
        this.high = new DMoneyValue(c.getHigh());
        this.low = new DMoneyValue(c.getLow());
        this.time = Instant.ofEpochSecond(
                c.getTime().getSeconds(),
                c.getTime().getNanos());
    }
}
