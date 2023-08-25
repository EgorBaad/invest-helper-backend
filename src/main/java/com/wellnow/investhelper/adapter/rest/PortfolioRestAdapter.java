package com.wellnow.investhelper.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.portfolio.GetPortfolioInbound;
import com.wellnow.investhelper.domain.DPortfolio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("portfolio")
@RequiredArgsConstructor
public class PortfolioRestAdapter {
    private final GetPortfolioInbound getPortfolioInbound;

    @GetMapping("/{accountId}")
    public ResponseEntity<DPortfolio> getAllBonds(@PathVariable String accountId) {
        return ResponseEntity.ok(getPortfolioInbound.execute(accountId));
    }
}
