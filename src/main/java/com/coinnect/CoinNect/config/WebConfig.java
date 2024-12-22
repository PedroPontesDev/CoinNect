package com.coinnect.CoinNect.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Value("${cors.originPatterns:default}")
	private String corsOriginPatterns;

	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		Map<String, MediaType> mediaTypess = Map.of("pdf", MediaType.APPLICATION_PDF, "xml", MediaType.APPLICATION_XML,
				"json", MediaType.APPLICATION_JSON);

		/*
		 * VIA QUERY PARAM
		 * 
		 * configurer.defaultContentType(MediaType.APPLICATION_JSON);
		 * configurer.mediaTypes(mediaTypess); configurer.favorParameter(true);
		 * configurer.parameterName("mediaType"); configurer.ignoreAcceptHeader(true);
		 * mediaTypess.forEach(configurer::mediaType);
		 * super.configureContentNegotiation(configurer);
		 */

		// VIA HEADER PARAM
		configurer.useRegisteredExtensionsOnly(false);
		configurer.favorParameter(false);
		configurer.mediaTypes(mediaTypess);
		configurer.ignoreAcceptHeader(false);
		mediaTypess.forEach(configurer::mediaType);
		super.configureContentNegotiation(configurer);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(corsOriginPatterns);
		super.addCorsMappings(registry);
	}

}
