package com.wellnow.investhelper.app.api.marketdata;

import com.wellnow.investhelper.app.exception.InvalidTokenException;
import ru.tinkoff.piapi.contract.v1.LastPrice;

import java.util.List;

public interface GetLastPricesOutbound {
    List<LastPrice> getLastPrices(String token, Iterable<String> figis) throws InvalidTokenException;
}
