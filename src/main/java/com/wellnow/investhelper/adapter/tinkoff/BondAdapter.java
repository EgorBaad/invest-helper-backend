package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

@Component
public class BondAdapter implements GetBondByFigiOutbound, GetBondsListOutbound {
    @Override
    public Bond getBondByFigi(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
        InvestApi api;
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        if (figi != null && !figi.isEmpty()) {
            try {
                return api.getInstrumentsService().getBondByFigiSync(figi);
            } catch (ApiRuntimeException e) {
                throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
            }
        } else {
            throw new InvalidApiRequestException("Invalid request. Empty FIGI.");
        }
    }

    @Override
    public List<Bond> getBondsList(String token) throws InvalidTokenException, InvalidApiRequestException {
        InvestApi api;
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token " + token);
        }
        try {
            return api.getInstrumentsService().getAllBondsSync();
        } catch (ApiRuntimeException e) {
            throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
        }
    }
}
