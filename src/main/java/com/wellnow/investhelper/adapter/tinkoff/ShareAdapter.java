package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.share.GetShareByFigiOutbound;

import ru.tinkoff.piapi.contract.v1.Share;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class ShareAdapter implements GetShareByFigiOutbound {
    private InvestApi api;

    public void init(String token) {
        if (token != null) {api = InvestApi.create(token);}
    }

    @Override
    public Share getShareByFigi(String token, String figi) {
        init(token);
        return api.getInstrumentsService().getShareByFigiSync(figi);
    }
}
