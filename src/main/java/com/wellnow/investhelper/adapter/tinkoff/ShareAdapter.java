package com.wellnow.investhelper.adapter.tinkoff;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.share.GetShareByFigiOutbound;

import ru.tinkoff.piapi.contract.v1.Share;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class ShareAdapter implements GetShareByFigiOutbound {
    private InvestApi api;

    public void init(String token) {
        api = InvestApi.create(token);
    }

    @Override
    public Share getShareByFigi(String figi) {
        init("t.iz5SOvygTW_963zXjxFk49EIYtV7gI_DHUif9_LbhyYkZCMyI1T-_njdnYJR4nW6HmluZdFijfreDJj8snVW1w");
        return api.getInstrumentsService().getShareByFigiSync(figi);
    }
}
