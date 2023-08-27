package com.wellnow.investhelper.app.api.instrument;

import java.util.List;

import ru.tinkoff.piapi.contract.v1.InstrumentShort;

public interface SearchForInstrumentOutbound {
    public List<InstrumentShort> searchForInstrument(String searchString, String type);
}
