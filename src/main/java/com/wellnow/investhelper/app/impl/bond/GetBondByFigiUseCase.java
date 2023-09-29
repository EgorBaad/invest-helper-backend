package com.wellnow.investhelper.app.impl.bond;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DBond;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.Bond;

@Component
@RequiredArgsConstructor
public class GetBondByFigiUseCase implements GetBondByFigiInbound {
    private final GetBondByFigiOutbound getBondByFigiOutbound;

    @Override
    public DBond execute(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
        Bond bond = getBondByFigiOutbound.getBondByFigi(token, figi);
        return new DBond(bond);
    }
}
