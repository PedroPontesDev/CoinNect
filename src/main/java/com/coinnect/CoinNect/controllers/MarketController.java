package com.coinnect.CoinNect.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coinnect.CoinNect.services.EnderecoServices;

@RestController
@RequestMapping(path = "/v1/market")
public class MarketController {

	@Autowired
	private EnderecoServices enderecoServices;
	
	@GetMapping(path = "/ver-proximidade")
	public ResponseEntity<Map<String, Object>> getDistance(@RequestParam Long contratanteId, @RequestParam Long prestadorId) throws Exception {
		double distance = enderecoServices.calcularDistanciaEntreUsuarios(prestadorId, contratanteId);
		
		Map<String, Object> response = Map.of("prestadorId:", prestadorId, 
											  "contratanteId:", contratanteId,
											  "distanceInKm:", distance);
		
		if(distance <= 0) throw new Exception("Distância não pode ser calculada!");
		
		return ResponseEntity.ok(response);
	}
}
