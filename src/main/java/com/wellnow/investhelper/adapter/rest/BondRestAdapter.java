package com.wellnow.investhelper.adapter.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListInbound;
import com.wellnow.investhelper.domain.DBond;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("bond")
@RequiredArgsConstructor
public class BondRestAdapter {
    private final GetBondByFigiInbound getBondByFigiInbound;
    private final GetBondsListInbound getBondsListInbound;

    @GetMapping("/{figi}") //http://127.0.0.1:8888/bond/BBG000B9XRY4
    public ResponseEntity<DBond> getBondByFigi(@RequestHeader("token") String token, @PathVariable String figi) {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(getBondByFigiInbound.execute(token, figi));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DBond>> getAllBonds(@RequestHeader("token") String token) {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(getBondsListInbound.execute(token));
    }
}
