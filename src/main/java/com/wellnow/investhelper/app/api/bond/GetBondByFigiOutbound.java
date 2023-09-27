package com.wellnow.investhelper.app.api.bond;

import ru.tinkoff.piapi.contract.v1.Bond;

public interface GetBondByFigiOutbound {
    public Bond getBondByFigi(String token, String figi);
}
