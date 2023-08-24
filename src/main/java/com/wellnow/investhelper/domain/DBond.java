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
public class DBond {
    String figi;
    String ticker;
    Integer lot;
    String currency;
    String name;
    MoneyValue nominal;
}
