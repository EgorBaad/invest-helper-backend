package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentOutbound;
import com.wellnow.investhelper.domain.Token;

import ru.tinkoff.piapi.contract.v1.InstrumentShort;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class InstrumentAdapter implements SearchForInstrumentOutbound {
    private InvestApi api;

    public void init() {
        api = InvestApi.create(Token.getToken());
    }

    @Override
    public List<InstrumentShort> searchForInstrument(String searchString, String type) {
        init();
        return api.getInstrumentsService().findInstrumentSync(searchString);
    }
}
