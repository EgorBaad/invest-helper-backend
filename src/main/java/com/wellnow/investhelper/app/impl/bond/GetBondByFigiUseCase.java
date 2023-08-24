package com.wellnow.investhelper.app.impl.bond;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.domain.DBond;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.Bond;

@Component
@RequiredArgsConstructor
public class GetBondByFigiUseCase implements GetBondByFigiInbound {
    private final GetBondByFigiOutbound getBondByFigiOutbound;
    
    @Override
    public DBond execute(String figi) {
        Bond bond = getBondByFigiOutbound.getBondByFigi(figi);
        return new DBond(bond.getFigi(), bond.getTicker(), bond.getLot(), bond.getCurrency(), bond.getName(), bond.getNominal());
    }
}
