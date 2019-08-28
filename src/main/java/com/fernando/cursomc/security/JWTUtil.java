package com.fernando.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTUtil {

//	
	@Value("${jwt.secret}")
	private String secret;

//	tempo de expiracao do token declarado la no aplication.properties
	@Value("${jwt.expiration}")
	private Long expiration;
	
//	nome do usuario que solicitou o token	
//	tempo que o tokem demora para expirar baseado na hora q foi requisitado	
//	converte o string para um array de bytes
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
}
