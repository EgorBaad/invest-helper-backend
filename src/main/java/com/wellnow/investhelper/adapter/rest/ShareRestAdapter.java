package com.wellnow.investhelper.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DShare;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("share")
@RequiredArgsConstructor
public class ShareRestAdapter {
    private final GetShareByFigiInbound getShareByFigiInbound;

    @GetMapping("/{figi}") // http://127.0.0.1:8888/share/BBG000B9XRY4
    public ResponseEntity<DShare> getShareByFigi(@RequestHeader("token") String token, @PathVariable String figi)
            throws InvalidTokenException, InvalidApiRequestException {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(getShareByFigiInbound.execute(token, figi));
    }
}
