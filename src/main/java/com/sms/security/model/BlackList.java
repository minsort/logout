package com.sms.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class BlackList implements Serializable {

    private String token;
    private Date timeCreated;

    public BlackList(String token, Date timeCreated) {
        this.token = token;
        this.timeCreated = timeCreated;
    }

}
