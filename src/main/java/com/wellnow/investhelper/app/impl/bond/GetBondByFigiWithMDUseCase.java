package com.wellnow.investhelper.app.impl.bond;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.bond.GetBondByFigiWithMDInbound;
import com.wellnow.investhelper.app.api.coupon.GetCouponListByBondOutbound;
import com.wellnow.investhelper.app.api.marketdata.GetCandlesOutbound;
import com.wellnow.investhelper.app.api.marketdata.GetClosePricesOutbound;
import com.wellnow.investhelper.app.api.marketdata.GetLastPricesOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetBondByFigiWithMDUseCase implements GetBondByFigiWithMDInbound {
    private final GetBondByFigiInbound getBondByFigiInbound;
    private final GetClosePricesOutbound getClosePricesOutbound;
    private final GetLastPricesOutbound getLastPricesOutbound;
    private final GetCandlesOutbound getCandlesOutbound;
    private final GetCouponListByBondOutbound getCouponListByBondOutbound;

    @Override
    public DBond execute(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
        DBond bond = getBondByFigiInbound.execute(token, figi);
        List<DMoneyValue> lastPrices = new ArrayList<>(getLastPricesOutbound
                .getLastPrices(token, Arrays.asList(figi))
                        .stream()
                        .map(i -> new DMoneyValue(i.getPrice())).toList());
        List<DCandle> candles = new ArrayList<>(getCandlesOutbound
                .getCandles(
                        token,
                        figi,
                        Instant.now().minus(1, ChronoUnit.DAYS),
                        Instant.now()).stream().map(DCandle::new).toList());

        bond.setMarketData(
                new DMarketData(
                        new DMoneyValue(getClosePricesOutbound.getClosePrices(token, figi).get(0).getPrice()),
                        lastPrices,
                        candles
                )
        );
        bond.setCouponList(getCouponListByBondOutbound
                .getCouponList(
                        token,
                        figi,
                        Instant.now(),
                        Instant.now().plus(365, ChronoUnit.DAYS)).stream().map(DCoupon::new).toList());

        return bond;
    }
}
