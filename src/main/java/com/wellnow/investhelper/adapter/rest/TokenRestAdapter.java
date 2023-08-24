package com.wellnow.investhelper.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellnow.investhelper.domain.Token;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("token")
@RequiredArgsConstructor
public class TokenRestAdapter {
    @PutMapping("/set") //http://127.0.0.1:8888/token/set
    public ResponseEntity<String> setToken(@RequestParam String token) {
        Token.setToken(token);
        return ResponseEntity.ok("good");
    }
}