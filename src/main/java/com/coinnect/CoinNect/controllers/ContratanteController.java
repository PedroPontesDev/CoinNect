package com.coinnect.CoinNect.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.services.impl.ContratanteServicesImpl;
import com.coinnect.CoinNect.services.impl.ContratoServicesImpl;

@RestController
@RequestMapping(path = "/v1/contratante")
public class ContratanteController {

	@Autowired
	private ContratanteServicesImpl contratanteServices;

	@Autowired
	private ContratoServicesImpl contratoServices;

	@PostMapping(path = "/registrar-cnpj", 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/pdf"})
	public ResponseEntity<ContratanteDTO> registrarContratantePorCnpj(@RequestBody ContratanteDTO contratante)
			throws Exception {
		ContratanteDTO novo = contratanteServices.registrarContrantePorCnpj(contratante);
		return new ResponseEntity<>(novo, HttpStatus.OK);
	}

	@GetMapping(path = "/download/{idContrato}", produces = "application/pdf")
	ResponseEntity<byte[]> gerarContratoSeFormalizado(@PathVariable Long idContrato) {
		byte[] pdf = contratoServices.gerarContratoFormalizadoPDF(idContrato);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contrato_" + idContrato + ".pdf");

		return ResponseEntity.ok()
				.headers(headers)
				.body(pdf);
	}
	
	@PostMapping
	public ContratoDTO oferecerContratoPrestador(Long prestadorId) {
		return null;
	}
}
