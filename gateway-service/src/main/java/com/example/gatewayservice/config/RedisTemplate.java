package com.example.gatewayservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplate {
//    public org.springframework.data.redis.core.RedisTemplate redisTemplate(@Value("${spring.redis.host}"),@Value("${spring.redis.port}")){
//        org.springframework.data.redis.core.RedisTemplate redisTemplate=new org.springframework.data.redis.core.RedisTemplate();
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//
//
//
//
//
//        return redisTemplate;
//    }
}
