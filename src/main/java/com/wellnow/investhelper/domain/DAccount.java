package com.wellnow.investhelper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.AccountType;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DAccount {
    String id;
    String name;
    AccountType type;
}
