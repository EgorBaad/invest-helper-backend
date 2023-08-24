package com.wellnow.investhelper.adapter.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.account.GetAccountsInbound;
import com.wellnow.investhelper.domain.DAccount;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountRestAdapter {
    private final GetAccountsInbound getAccountsInbound;

    @GetMapping("/all") //http://127.0.0.1:8888/account/all
    public ResponseEntity<List<DAccount>> getShareByFigi() {
        return ResponseEntity.ok(getAccountsInbound.execute());
    }
}
