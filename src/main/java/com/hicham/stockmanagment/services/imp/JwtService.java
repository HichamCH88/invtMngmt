package com.hicham.stockmanagment.services.imp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private final static String SECRET_KEY="22fd21df39b99b40239b0a0c49717d6ff1fc9d314cb4bce02a09e69e8c69199982a5b945af84ddf2999386215d20e9c1d17f2f9e8ac57c37c45abf51949bca0b59323db9e0623d19c509bb4b99b6f6ec4c8a6abbd3223707c82614434c3bf36d16895d78e5e9e04a2af6739639fe6ad6ffa8ba8026bb8b109839eb0f9ca13a67132979b829f3a9567643e60e0d7616c985625de60c51200ed310cd3ce9973224cadaab8603beabb3e30cde4e93b62a0fe07b875a81003735c2b60b9d8703deaf7120343aa9235178ca5ebf56f832c9c19187fd3560598e4d87dfa3dbca9253486f933bcfb2a07cbac92a1ca29d3b261f49959898a6a25fbb4a1c7fd9552efdb7";

    public String extractUsername(String jwToken) {
        return extractClaim(jwToken,Claims::getSubject);
    }

    public Date extractExpirationDate(String jwToken){
        return extractClaim(jwToken,Claims::getExpiration);
    }

    public <T> T extractClaim(String jwToken, Function<Claims,T> resolver){
        final Claims claims=extractAllClaims(jwToken);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigninKey() {
        byte[] keyByte= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        boolean valid=username.equals(userDetails.getUsername());//TODO &&isTokenExpired(token);
        System.out.println("Token is valid");
        return (valid);

    }

    public boolean isTokenExpired(String token){
        return extractExpirationDate(token).before(new Date(System.currentTimeMillis()));
    }

    public String generateJwToken(UserDetails userDetails){
        return generateJwToken(new HashMap<>(),userDetails);
    }

    public String generateJwToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
