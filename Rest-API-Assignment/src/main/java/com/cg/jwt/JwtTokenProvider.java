package com.cg.jwt;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import com.cg.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@Value("${security.jwt.token.secret}")
	private String jwtSecret;

	@Value("${security.jwt.token.apikey}")
	private String jwtAPIKey;

	private long validityInMilliseconds = (1000 * 60 * 60 * 24); // 1Day

	@Autowired
	private UserDetailsService userDetailsService;

	@PostConstruct
	protected void init() {
		jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
	}

	public String createToken(UserEntity userEntity) {
		return createToken(userEntity.getEmail(), userEntity.getLocation());
	}

	public String createToken(String email, String location) {

		Claims claims = Jwts.claims().setSubject(email);

		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);

		claims.put("loggedInUserIp", location);

		return Jwts.builder()//
				.setClaims(claims)//
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, jwtSecret)//
				.compact();
	}

	public Authentication getAuthentication(String token) {
		try {
			String loggedInUserIp = getLoggedinUserIp(token);
			UserEntity userDetails = (UserEntity) this.userDetailsService.loadUserByUsername(getUsername(token));
			userDetails.setLocation(loggedInUserIp);
			return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getUsername(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	private String getLoggedinUserIp(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("loggedInUserIp").toString();
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);

			return !claims.getBody().getExpiration().before(new Date());
		} catch (JwtException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername(jwtAPIKey).password("password").roles("USER").build());
		return manager;
	}

}
