package com.coinnect.CoinNect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{

	@Value("${cors.originPatterns:default}")
	private String corsOriginPatterns = "";

	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false)
				  .ignoreAcceptHeader(false)
				  .mediaType("pdf", MediaType.APPLICATION_PDF)
				  .mediaType("xml", MediaType.APPLICATION_XML)
				  .defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(corsOriginPatterns);
	}
	
	
}
