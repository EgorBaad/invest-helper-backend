package com.wellnow.investhelper.adapter.tinkoff;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.InstrumentShort;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

import javax.annotation.PreDestroy;

@Component
@Slf4j
public class InstrumentAdapter implements SearchForInstrumentOutbound {
    private InvestApi api;

    @Override
    public List<InstrumentShort> searchForInstrument(String token, String searchString, String type)
            throws InvalidTokenException, InvalidApiRequestException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        if (searchString != null && !searchString.isEmpty()) {
            try {
                return api.getInstrumentsService().findInstrumentSync(searchString);
            } catch (ApiRuntimeException e) {
                throw new InvalidApiRequestException("Invalid request. " + e.getMessage());
            } finally {
                log.info("InstrumentAdapter for Account adapter run");
                api.destroy(3);
            }
        } else {
            throw new InvalidApiRequestException("Invalid request. Empty searchString.");
        }
    }
}
