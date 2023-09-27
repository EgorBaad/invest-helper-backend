package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentOutbound;

import ru.tinkoff.piapi.contract.v1.InstrumentShort;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class InstrumentAdapter implements SearchForInstrumentOutbound {
    private InvestApi api;

    public void init(String token) {
        if (token != null) {api = InvestApi.create(token);}
    }

    @Override
    public List<InstrumentShort> searchForInstrument(String token, String searchString, String type) {
        init(token);
        return api.getInstrumentsService().findInstrumentSync(searchString);
    }
}
