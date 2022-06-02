package com.sms.security.pojoSerialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

//используется для сериализации

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupRequest {

    @NotNull
    private String surname;

    @NotNull
    private String name;

    private String middleName;//????????????

    private String group;//?????????????????

    @Email
    @NotNull
    private String email;

    @NotNull
    private Set<String> roles;

    @NotNull
    private String password;

    @NotNull
    private String accountType;
}
