package com.sms.security.controller;

import com.sms.security.model.BlackList;
import com.sms.security.repository.BlacklistRepository;
import com.sms.security.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogoutController {

    @Autowired
    private BlacklistService blacklistService;

    @Autowired
    BlacklistRepository blacklistRepository;

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(name= HttpHeaders.AUTHORIZATION) String header) {
        blacklistService.saveToken(header);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<BlackList>all(){
        return blacklistRepository.all();
    }
}
