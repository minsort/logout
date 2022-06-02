package com.sms.security.pojoSerialization;

import lombok.AllArgsConstructor;
import lombok.Data;

// На каждый запрос будем посылать ответ
@AllArgsConstructor
@Data
public class MessageResponse {
    private String message;
}
