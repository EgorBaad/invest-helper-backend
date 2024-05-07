package com.wellnow.investhelper.domain;

import com.google.protobuf.Timestamp;
import lombok.*;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.time.Instant;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DCoupon {
    Instant paymentDate;
    Long number;
    DMoneyValue paymentAmount;
    Instant periodStart;
    Instant periodEnd;

    public DCoupon(Coupon c) {
        this.paymentDate = Instant.ofEpochSecond(
                c.getCouponDate().getSeconds(),
                c.getCouponDate().getNanos());
        this.number = c.getCouponNumber();
        this.paymentAmount = new DMoneyValue(c.getPayOneBond());
        this.periodStart = Instant.ofEpochSecond(
                c.getCouponStartDate().getSeconds(),
                c.getCouponStartDate().getNanos());
        this.periodEnd = Instant.ofEpochSecond(
                c.getCouponEndDate().getSeconds(),
                c.getCouponEndDate().getNanos());
    }
}
