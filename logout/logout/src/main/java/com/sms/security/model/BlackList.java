package com.sms.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class BlackList implements Serializable {

    private String token;

    public BlackList(String token) {
        this.token = token;
    }
}
