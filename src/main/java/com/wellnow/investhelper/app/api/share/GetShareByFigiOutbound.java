package com.wellnow.investhelper.app.api.share;

import ru.tinkoff.piapi.contract.v1.Share;

public interface GetShareByFigiOutbound {
    public Share getShareByFigi(String figi);
}
