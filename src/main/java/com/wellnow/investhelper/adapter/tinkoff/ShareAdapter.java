package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.share.GetShareByFigiOutbound;

import ru.tinkoff.piapi.contract.v1.Share;
import ru.tinkoff.piapi.core.InvestApi;
import com.wellnow.investhelper.domain.Token;

@Component
public class ShareAdapter implements GetShareByFigiOutbound {
    private InvestApi api;

    public void init() {
        api = InvestApi.create(Token.getToken());
    }

    @Override
    public Share getShareByFigi(String figi) {
        init();
        return api.getInstrumentsService().getShareByFigiSync(figi);
    }
}
