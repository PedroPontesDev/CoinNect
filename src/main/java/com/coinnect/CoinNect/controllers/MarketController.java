package com.coinnect.CoinNect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.services.impl.ContratanteServicesImpl;

@RestController
@RequestMapping(path = "/v1/market")
public class MarketController {

	//IMPLEMENTAR FUNÇÕES DE ENCONTRAR CONTRATANTES PROXIMOS E FAZER OS TRADES
	
}
