package com.wellnow.investhelper.app.api.bond;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DBond;

public interface GetBondsListInbound {
    public List<DBond> execute(String token) throws InvalidTokenException, InvalidApiRequestException;
}
