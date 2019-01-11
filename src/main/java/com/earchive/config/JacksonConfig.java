package com.earchive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.earchive.dto.ManagedContainerDTO;
import com.earchive.dto.SimpleContainerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(ManagedContainerDTO.class);
				objectMapper.registerSubtypes(SimpleContainerDTO.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}