package com.coinnect.CoinNect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("CoinNect - Conectando Pessoas a Serviços")
						.description("WebService De Contratamento De Serviços Informais")
						.version("v1"));
	}
	
}
