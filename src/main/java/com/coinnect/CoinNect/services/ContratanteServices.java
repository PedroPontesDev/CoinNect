package com.coinnect.CoinNect.services;

import java.util.List;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.enums.StatusContrato;

public interface ContratanteServices {

	ContratanteDTO registrarContrantePorCpf(ContratanteDTO contratante) throws Exception; 
	ContratanteDTO registrarContrantePorCnpj(ContratanteDTO contratanteCnpj);
	ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId);
	Double fazerAvaliacaoContratante(Double nota, Long contratanteId, Long prestadorId, StatusContrato status);
	List<ContratanteDTO> listarContrantesBemAvaliados();
	
	
}
