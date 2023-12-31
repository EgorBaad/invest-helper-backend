package com.wellnow.investhelper.adapter.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.account.GetAccountsInbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DAccount;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountRestAdapter {
    private final GetAccountsInbound getAccountsInbound;

    @GetMapping("/all") // http://127.0.0.1:8888/account/all
    public ResponseEntity<List<DAccount>> getShareByFigi(@RequestHeader("token") String token)
            throws InvalidTokenException, InvalidApiRequestException {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(getAccountsInbound.execute(token));
    }
}
