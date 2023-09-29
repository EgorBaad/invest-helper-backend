package com.wellnow.investhelper.app.api.instrument;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.InstrumentShort;

public interface SearchForInstrumentOutbound {
    public List<InstrumentShort> searchForInstrument(String token, String searchString, String type)
            throws InvalidTokenException, InvalidApiRequestException;
}
