package com.maakesbe.authentication.security.auth.jwt;

import java.util.List;
import java.util.stream.Collectors;

import com.maakesbe.query.controllers.EventsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.maakesbe.authentication.security.auth.JwtAuthenticationToken;
import com.maakesbe.authentication.security.config.JwtSettings;
import com.maakesbe.authentication.security.model.UserContext;
import com.maakesbe.authentication.security.model.token.JwtToken;
import com.maakesbe.authentication.security.model.token.RawAccessJwtToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * An {@link AuthenticationProvider} implementation that will use provided
 * instance of {@link JwtToken} to perform authentication.
 * 
 * @author vladimir.stankovic
 *
 * Aug 5, 2016
 */
@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    JwtSettings jwtSettings;
    
    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        
        UserContext context = UserContext.create(subject, authorities);
        
        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
