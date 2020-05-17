package com.kusak.dariusz.simplejwtauthorizationproject.security;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID = 3L;

    String username;
    String password;
}
