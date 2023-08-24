package com.wellnow.investhelper.app.api.bond;

import com.wellnow.investhelper.domain.DBond;

public interface GetBondByFigiInbound {
    public DBond execute(String figi);
}
