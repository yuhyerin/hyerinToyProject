package com.riri.security.dto;

import lombok.Data;

@Data
public class JwtRequest {

    private String email;

    private String password;

}