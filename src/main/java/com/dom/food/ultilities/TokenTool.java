// package com.dom.food.ultilities;

// import java.util.function.Function;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;

// public class TokenTool {

// @Value("${jwt.secret}")
// private String secret = System.getenv("jwt.secret") != null ?
// System.getenv("jwt.secret") : "SuperSecret";

// public String getSecret() {
// return this.secret;
// }

// public String getUsernameId(String bearer) {
// if (bearer.startsWith("Bearer ")) {
// String token = bearer.substring(7);
// return getClaimFromToken(token, Claims::getSubject);
// }
// return null;
// }

// public <T> T getClaimFromToken(String token, Function<Claims, T>
// claimsResolver) {
// final Claims claims = getAllClaimsFromToken(token);
// return claimsResolver.apply(claims);
// }

// private Claims getAllClaimsFromToken(String token) {
// return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
// }
// }
