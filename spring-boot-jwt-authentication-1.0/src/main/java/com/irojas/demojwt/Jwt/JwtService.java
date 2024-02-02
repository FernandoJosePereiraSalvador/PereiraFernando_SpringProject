package com.irojas.demojwt.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    /**
     * Generates a JWT token for the specified user.
     *
     * @param user The UserDetails object representing the user.
     * @return The generated JWT token.
     */
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    /**
     * Generates a JWT token for the specified user with optional extra claims.
     *
     * @param extraClaims Additional claims to include in the token.
     * @param user The UserDetails object representing the user.
     * @return The generated JWT token.
     */
    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    /**
     * Retrieves the cryptographic key used for signing JWT tokens.
     *
     * @return The cryptographic key.
     */
    private Key getKey() {
       byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extracts the username from the JWT token.
     *
     * @param token The JWT token.
     * @return The username extracted from the token.
     */
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    /**
     * Validates whether a JWT token is valid for the specified user.
     *
     * @param token The JWT token.
     * @param userDetails The UserDetails object representing the user.
     * @return True if the token is valid, otherwise false.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    /**
     * Retrieves all claims from the JWT token.
     *
     * @param token The JWT token.
     * @return The Claims object containing all claims extracted from the token.
     */
    private Claims getAllClaims(String token)
    {
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    /**
     * Extracts a specific claim from the JWT token.
     *
     * @param token The JWT token.
     * @param claimsResolver A function to resolve the desired claim from the token's claims.
     * @return The resolved claim.
     */
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Retrieves the expiration date of the JWT token.
     *
     * @param token The JWT token.
     * @return The expiration date extracted from the token.
     */
    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    /**
     * Checks if the JWT token has expired.
     *
     * @param token The JWT token.
     * @return True if the token has expired, otherwise false.
     */
    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }
    
}
