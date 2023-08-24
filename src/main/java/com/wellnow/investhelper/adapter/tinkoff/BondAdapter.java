package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiOutbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListOutbound;
import com.wellnow.investhelper.domain.Token;

import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class BondAdapter implements GetBondByFigiOutbound, GetBondsListOutbound {
    private InvestApi api;

    public void init() {
        api = InvestApi.create(Token.getToken());
    }

    @Override
    public Bond getBondByFigi(String figi) {
        init();
        return api.getInstrumentsService().getBondByFigiSync(figi);
    }

    @Override
    public List<Bond> getBondsList() {
        init();
        return api.getInstrumentsService().getAllBondsSync();
    }
}
