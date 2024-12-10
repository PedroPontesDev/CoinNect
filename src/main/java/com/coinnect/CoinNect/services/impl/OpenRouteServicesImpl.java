package com.coinnect.CoinNect.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenRouteServicesImpl {

	@Value("${openroute.api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	public double getDistance(double originLat, double originLon, double destLat, double destLon) {
		String url = "https://api.openrouteservice.org/v2/matrix/driving-car";
		
		// Corpo da request
		Map<String, Object> requestBody = Map.of(
                "locations", List.of(
                        List.of(originLon, originLat),
                        List.of(destLon, destLat)
                ),
                "metrics", List.of("distance")
        );
		
		// Montando a Request
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.set("Authorization", apiKey);
		
		// Criando a Entidade que será enviada na request
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String,Object>>(requestBody, header);
		
		try {
		
		// Fazendo a chamada
		ResponseEntity<Map> response = restTemplate.exchange(url , HttpMethod.POST, requestEntity, Map.class);
		
	    // Extraindo a distância da matriz de distâncias para KM
		List<List<Double>> distances = (List<List<Double>>) response.getBody().get("distances");
		return distances.get(0).get(1) / 1000.0;
		
		}catch(Exception e) {
			throw new RuntimeException("Error ao consumir API do OpenRoute " + e);
		}
	}
	
}
