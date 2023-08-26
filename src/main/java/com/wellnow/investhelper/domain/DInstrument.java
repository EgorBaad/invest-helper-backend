package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
