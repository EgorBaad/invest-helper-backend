package com.wellnow.investhelper.adapter.tinkoff;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.share.GetShareByFigiOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

import ru.tinkoff.piapi.contract.v1.Share;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.exception.ApiRuntimeException;

import javax.annotation.PreDestroy;

@Component
@Slf4j
public class ShareAdapter implements GetShareByFigiOutbound {
    InvestApi api;

    @Override
    public Share getShareByFigi(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
        if (token != null) {
            api = InvestApi.create(token);
        } else {
            throw new InvalidTokenException("Invalid token null");
        }
        if (figi != null && !figi.isEmpty()) {
            try {
                return api.getInstrumentsService().getShareByFigiSync(figi);
            } catch (ApiRuntimeException e) {
                throw new InvalidApiRequestException("Invalid request: " + e.getMessage());
            } finally {
                log.info("PortfolioAdapter for Account adapter run");
                api.destroy(3);
            }
        } else {
            log.info("PortfolioAdapter for Account adapter run");
            api.destroy(3);
            throw new InvalidApiRequestException("Invalid request. Empty FIGI.");
        }
    }
}
