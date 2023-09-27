package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListOutbound;

import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class BondAdapter implements GetBondByFigiOutbound, GetBondsListOutbound {
    private InvestApi api;

    public void init(String token) {
        if (token != null) {api = InvestApi.create(token);}
    }

    @Override
    public Bond getBondByFigi(String token, String figi) {
        init(token);
        return api.getInstrumentsService().getBondByFigiSync(figi);
    }

    @Override
    public List<Bond> getBondsList(String token) {
        init(token);
        return api.getInstrumentsService().getAllBondsSync();
    }
}
