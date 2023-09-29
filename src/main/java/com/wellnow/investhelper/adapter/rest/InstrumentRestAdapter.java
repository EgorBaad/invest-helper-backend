package com.wellnow.investhelper.adapter.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.instrument.SearchForInstrumentInbound;
import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;
import com.wellnow.investhelper.domain.DInstrument;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("instrument")
@RequiredArgsConstructor
public class InstrumentRestAdapter {
    private final SearchForInstrumentInbound searchForInstrumentInbound;

    @GetMapping("/search")
    public ResponseEntity<List<DInstrument>> getBondByFigi(@RequestHeader("token") String token,
            @RequestParam String searchString) throws InvalidTokenException, InvalidApiRequestException {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }
        
        return ResponseEntity.ok(searchForInstrumentInbound.execute(token, searchString, ""));
    }
}
