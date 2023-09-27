package com.wellnow.investhelper.app.impl.instrument;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentInbound;
import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentOutbound;
import com.wellnow.investhelper.domain.DInstrument;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.InstrumentShort;

@Component
@RequiredArgsConstructor
public class SearchForInstrumentUseCase implements SearchForInstrumentInbound {
    private final SearchForInstrumentOutbound searchForBondOutbound;
    
    @Override
    public List<DInstrument> execute(String token, String searchString, String type) {
        List<InstrumentShort> instruments = searchForBondOutbound.searchForInstrument(token, searchString, type);
        List<DInstrument> instrList = new ArrayList<>();
        for (InstrumentShort instrument : instruments) {
            instrList.add(new DInstrument(instrument));
        }

        return instrList;
    }
}
