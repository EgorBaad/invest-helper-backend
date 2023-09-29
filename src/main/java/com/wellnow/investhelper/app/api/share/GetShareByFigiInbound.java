package com.wellnow.investhelper.app.api.share;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DShare;

public interface GetShareByFigiInbound {
    public DShare execute(String token, String figi) throws InvalidTokenException, InvalidApiRequestException;
}
