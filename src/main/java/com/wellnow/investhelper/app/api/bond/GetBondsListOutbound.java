package com.wellnow.investhelper.app.api.bond;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Bond;

public interface GetBondsListOutbound {
    public List<Bond> getBondsList(String token) throws InvalidTokenException, InvalidApiRequestException;
}
