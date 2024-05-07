package com.wellnow.investhelper.app.api.coupon;

import com.wellnow.investhelper.app.exception.InvalidTokenException;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.time.Instant;
import java.util.List;

public interface GetCouponListByBondOutbound {
    List<Coupon> getCouponList(String token, String figi, Instant from, Instant to) throws InvalidTokenException;
}
