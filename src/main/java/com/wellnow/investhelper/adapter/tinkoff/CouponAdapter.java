package com.wellnow.investhelper.adapter.tinkoff;

import com.wellnow.investhelper.app.api.coupon.GetCouponListByBondOutbound;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import org.springframework.stereotype.Component;
import ru.tinkoff.piapi.contract.v1.Coupon;
import ru.tinkoff.piapi.core.InvestApi;

import java.time.Instant;
import java.util.List;

@Component
public class CouponAdapter implements GetCouponListByBondOutbound {
    private InvestApi api;

    @Override
    public List<Coupon> getCouponList(String token, String figi, Instant from, Instant to) throws InvalidTokenException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        List<Coupon> ret = api.getInstrumentsService().getBondCouponsSync(figi, from, to);
        api.destroy(3);

        return  ret;
    }
}
