package com.wellnow.investhelper.app.api.share;

import com.wellnow.investhelper.domain.DShare;

public interface GetShareByFigiInbound {
    public DShare execute(String figi);
}
