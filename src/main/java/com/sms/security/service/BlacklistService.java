package com.sms.security.service;

import com.sms.security.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService {

    @Autowired
    BlacklistRepository blacklistRepository;

    public boolean isTokenExist(String token) {
        return blacklistRepository.isTokenExist(token);
    }

    public void saveToken(String token) {
        blacklistRepository.saveToken(token);
    }

}
