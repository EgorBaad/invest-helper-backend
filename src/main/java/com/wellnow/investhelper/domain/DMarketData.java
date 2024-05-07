package com.wellnow.investhelper.domain;

import lombok.*;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DMarketData {
    DMoneyValue closePrice;
    List<DMoneyValue> lastPrice;
    List<DCandle> candles;
}
