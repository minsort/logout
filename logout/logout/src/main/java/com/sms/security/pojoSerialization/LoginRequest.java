package com.sms.security.pojoSerialization;

import lombok.Data;

//объект чтобы залогиниться
@Data
public class LoginRequest {
    private String email;
    private String password;
}
