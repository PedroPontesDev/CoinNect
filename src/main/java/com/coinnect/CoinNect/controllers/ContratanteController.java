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
@RequestMapping(path = "/api/contratante/v1")
public class ContratanteController {

	@Autowired
	private ContratanteServicesImpl contratanteServices;
	
	@PostMapping(path = "/registrar-cnpj")
	public ResponseEntity<ContratanteDTO> registrarContratantePorCnpj(@RequestBody ContratanteDTO contratante) throws Exception {
		ContratanteDTO novo = contratanteServices.registrarContrantePorCnpj(contratante);
		return new ResponseEntity<>(novo, HttpStatus.OK);
	}
	
}
