package com.wellnow.investhelper.app.impl.share;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;
import com.wellnow.investhelper.app.api.share.GetShareByFigiOutbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DShare;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.Share;

@Component
@RequiredArgsConstructor
public class GetShareByFigiUseCase implements GetShareByFigiInbound {
    private final GetShareByFigiOutbound getShareByFigiOutbound;

    @Override
    public DShare execute(String token, String figi) throws InvalidTokenException, InvalidApiRequestException {
        Share share = getShareByFigiOutbound.getShareByFigi(token, figi);
        return new DShare(share);
    }
}
