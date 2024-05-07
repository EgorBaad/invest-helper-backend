package com.wellnow.investhelper.domain;

import com.google.protobuf.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tinkoff.piapi.contract.v1.Bond;

import java.time.Instant;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DBond extends DInstrument {
    DMoneyValue nominal;
    DMoneyValue accumulatedCouponIncome;
    Integer paymentsPerYear;
    Instant maturityDate;
    List<DCoupon> couponList;

    public DBond(Bond bond) {
        this.figi = bond.getFigi();
        this.ticker = bond.getTicker();
        this.lot = bond.getLot();
        this.currency = bond.getCurrency();
        this.country = bond.getCountryOfRisk();
        this.name = bond.getName();
        this.nominal = new DMoneyValue(bond.getNominal());
        this.qualOnly = bond.getForQualInvestorFlag();
        this.accumulatedCouponIncome = new DMoneyValue(bond.getAciValue());
        this.paymentsPerYear = bond.getCouponQuantityPerYear();
        this.maturityDate = Instant.ofEpochSecond(
                bond.getMaturityDate().getSeconds(),
                bond.getMaturityDate().getNanos());
    }
}
