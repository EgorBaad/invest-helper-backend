package com.wellnow.investhelper.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.app.api.token.TestTokenInbound;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("token")
@RequiredArgsConstructor
public class TokenRestAdapter {
    private final TestTokenInbound testTokenInbound;

    @PutMapping("/test") //http://127.0.0.1:8888/token/test
    public ResponseEntity<Boolean> testToken(@RequestParam String token) {
        if (token == null || token == "") {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(testTokenInbound.execute(token));
    }
}
