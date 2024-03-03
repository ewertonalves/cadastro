package com.redemob.cadastro.config;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.redemob.cadastro.model.Cadastro;

@Configuration
public class RedisConfig {

    private final StringRedisTemplate redisTemplate;

    public RedisConfig(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    @Bean
    public RedisTemplate<Long, Cadastro> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Cadastro> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    public Set<String> getRecentDataFromCache() {
        Instant twentyFourHoursAgo = Instant.now().minus(Duration.ofHours(24));
        return redisTemplate.opsForZSet().rangeByScore("cache_key", twentyFourHoursAgo.toEpochMilli(), Double.POSITIVE_INFINITY);
    }

    public Exception retrieveRecentData() throws Exception{
        Set<String> recentData = getRecentDataFromCache();
        return new Exception("Dados recentes recuperados: " + recentData);
    }
}
