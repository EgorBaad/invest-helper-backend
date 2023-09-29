package com.wellnow.investhelper.app.api.instrument;

import java.util.List;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DInstrument;

public interface SearchForInstrumentInbound {
    public List<DInstrument> execute(String token, String searchString, String type)
            throws InvalidTokenException, InvalidApiRequestException;
}
