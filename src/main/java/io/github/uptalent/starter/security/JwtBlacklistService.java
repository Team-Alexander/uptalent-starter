package io.github.uptalent.starter.security;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Lazy
@Service
@RequiredArgsConstructor
public class JwtBlacklistService {
    private final static String BEARER_PREFIX = "Bearer ";
    private final static String JWT_BLACKLIST_KEY = "jwt_blacklist:";
    private final RedisTemplate<String, String> redisTemplate;

    @SneakyThrows
    public void addToBlacklist(String token) {
        token = token.substring(BEARER_PREFIX.length());
        JWTClaimsSet claims = JWTParser.parse(token).getJWTClaimsSet();
        Instant tokenExpiration = claims.getExpirationTime().toInstant();
        String key = JWT_BLACKLIST_KEY + token.toLowerCase();

        redisTemplate.opsForValue().set(key, "");
        redisTemplate.expireAt(key, tokenExpiration);
    }
}
