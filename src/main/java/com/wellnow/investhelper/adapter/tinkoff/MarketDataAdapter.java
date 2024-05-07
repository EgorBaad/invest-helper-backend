package com.wellnow.investhelper.adapter.tinkoff;

import com.wellnow.investhelper.app.api.marketdata.GetCandlesOutbound;
import com.wellnow.investhelper.app.api.marketdata.GetClosePricesOutbound;
import com.wellnow.investhelper.app.api.marketdata.GetLastPricesOutbound;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import org.springframework.stereotype.Component;
import ru.tinkoff.piapi.contract.v1.*;
import ru.tinkoff.piapi.core.InvestApi;

import java.time.Instant;
import java.util.List;

@Component
public class MarketDataAdapter implements GetClosePricesOutbound, GetLastPricesOutbound, GetCandlesOutbound {
    private InvestApi api;

    public List<InstrumentClosePriceResponse> getClosePrices(String token, String figi) throws InvalidTokenException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        List<InstrumentClosePriceResponse> ret = api.getMarketDataService().getClosePricesSync(figi);
        api.destroy(3);

        return ret;
    }

    public List<LastPrice> getLastPrices(String token, Iterable<String> figis) throws InvalidTokenException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        List<LastPrice> ret = api.getMarketDataService().getLastPricesSync(figis);
        api.destroy(3);

        return ret;
    }

    public List<HistoricCandle> getCandles(String token, String figi, Instant from, Instant to)
            throws InvalidTokenException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        List<HistoricCandle> ret = api.getMarketDataService()
                .getCandlesSync(figi, from, to, CandleInterval.CANDLE_INTERVAL_DAY);
        api.destroy(3);

        return ret;
    }
}
