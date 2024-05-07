package com.wellnow.investhelper.app.api.marketdata;

import com.wellnow.investhelper.app.exception.InvalidTokenException;
import ru.tinkoff.piapi.contract.v1.InstrumentClosePriceResponse;

import java.util.List;

public interface GetClosePricesOutbound {
    List<InstrumentClosePriceResponse> getClosePrices(String token, String figi) throws InvalidTokenException;
}
