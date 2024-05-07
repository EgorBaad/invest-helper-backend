package com.wellnow.investhelper.app.api.marketdata;

import com.wellnow.investhelper.app.exception.InvalidTokenException;
import ru.tinkoff.piapi.contract.v1.HistoricCandle;

import java.time.Instant;
import java.util.List;

public interface GetCandlesOutbound {
    List<HistoricCandle> getCandles(String token, String figi, Instant from, Instant to) throws InvalidTokenException;
}
