package com.wellnow.investhelper.app.api.bond;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DBond;

public interface GetBondByFigiWithMDInbound {
    DBond execute(String token, String figi) throws InvalidTokenException, InvalidApiRequestException;
}
