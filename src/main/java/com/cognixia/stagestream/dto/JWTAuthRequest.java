package com.cognixia.stagestream.dto;

import lombok.Data;

@Data
public class JWTAuthRequest {
	private String username;  // email
	private String password;
}