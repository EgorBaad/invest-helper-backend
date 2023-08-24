package com.wellnow.investhelper.adapter.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.bond.GetBondByFigiInbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListInbound;
import com.wellnow.investhelper.domain.DBond;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("bond")
@RequiredArgsConstructor
public class BondRestAdapter {
    private final GetBondByFigiInbound getBondByFigiInbound;
    private final GetBondsListInbound getBondsListInbound;

    @GetMapping("/{figi}") //http://127.0.0.1:8888/bond/BBG000B9XRY4
    public ResponseEntity<DBond> getBondByFigi(@PathVariable String figi) {
        return ResponseEntity.ok(getBondByFigiInbound.execute(figi));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DBond>> getAllBonds() {
        return ResponseEntity.ok(getBondsListInbound.execute());
    }
}
