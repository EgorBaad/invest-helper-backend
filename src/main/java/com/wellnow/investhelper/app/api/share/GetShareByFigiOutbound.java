package com.wellnow.investhelper.app.api.share;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Share;

public interface GetShareByFigiOutbound {
    public Share getShareByFigi(String token, String figi) throws InvalidTokenException, InvalidApiRequestException;
}
