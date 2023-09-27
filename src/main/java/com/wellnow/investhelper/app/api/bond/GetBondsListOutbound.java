package com.wellnow.investhelper.app.api.bond;

import java.util.List;

import ru.tinkoff.piapi.contract.v1.Bond;

public interface GetBondsListOutbound {
    public List<Bond> getBondsList(String token);
}
