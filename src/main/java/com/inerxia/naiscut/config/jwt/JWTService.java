package com.inerxia.naiscut.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import io.jsonwebtoken.security.Keys;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Component
public class JWTService {
    public static final String SECRET = Base64Utils.encodeToString("com.inerxia.naiscut.seg.12345678.una.clave.secreta.ni.el.putas.le.digo.que.es.s3cr3t4-_-".getBytes());//clave secreta
    public static final long EXPIRATION_DATE = 14000000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public String create(Authentication auth) throws IOException {

        String username = ((User) auth.getPrincipal()).getUsername();

        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder().setClaims(claims).setSubject(username)
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE)).compact();

        return token;
    }

    public boolean validate(String token) {

        try {

            getClaims(token);

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }

    }

    public Claims getClaims(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes())
                .parseClaimsJws(resolve(token)).getBody();
        return claims;
    }

    public String getUsername(String token) {
        // TODO Auto-generated method stub
        return getClaims(token).getSubject();
    }

    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
        Object roles = getClaims(token).get("authorities");

        Collection<? extends GrantedAuthority> authorities = Arrays
                .asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                        .readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

        return authorities;
    }


    public String resolve(String token) {
        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            return token.replace(TOKEN_PREFIX, "");
        }
        return null;
    }
}
