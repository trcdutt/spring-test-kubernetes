package com.trc.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 601)
public class SessionConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory(RedisProperties props) {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(props.getHost(), props.getPort());
		config.setPassword(props.getPassword());
		return new LettuceConnectionFactory(config);

	}
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connFactory);
		return template;
	}
//	@Bean
//	public ViewResolver internalResourceViewResolver() {
//	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
//	    bean.setViewClass(JstlView.class);
//	    bean.setPrefix("/templates/");
//	    bean.setSuffix(".jsp");
//	    return bean;
//	}
}
