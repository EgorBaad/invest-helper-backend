package com.wellnow.investhelper.app.api.bond;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Bond;

public interface GetBondByFigiOutbound {
    public Bond getBondByFigi(String token, String figi) throws InvalidTokenException, InvalidApiRequestException;
}
