package com.wellnow.investhelper.adapter.tinkoff;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

import java.util.List;

@Component
@Slf4j
public class BondAdapter implements GetBondByFigiOutbound, GetBondsListOutbound {
    private InvestApi api;

    @Override
    public Bond getBondByFigi(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
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
            } finally {
                log.info("BondAdapter for Account adapter run");
                api.destroy(3);
            }
        } else {
            log.info("BondAdapter for Account adapter run");
            api.destroy(3);
            throw new InvalidApiRequestException("Invalid request. Empty FIGI.");
        }
    }

    @Override
    public List<Bond> getBondsList(String token) throws InvalidTokenException, InvalidApiRequestException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        try {
            return api.getInstrumentsService().getAllBondsSync();
        } catch (ApiRuntimeException e) {
            throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
        } finally {
            log.info("BondAdapter for Account adapter run");
            api.destroy(3);
        }
    }
}
