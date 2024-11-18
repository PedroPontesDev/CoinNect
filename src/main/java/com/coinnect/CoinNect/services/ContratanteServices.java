package com.coinnect.CoinNect.services;

import java.util.List;
import java.util.Set;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.enums.StatusContrato;

public interface ContratanteServices {

	ContratanteDTO registrarContrantePorCpf(ContratanteDTO contratante) throws Exception; 
	ContratanteDTO registrarContrantePorCnpj(ContratanteDTO contratanteCnpj) throws Exception;
	ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId);
	ContratoDTO visualizarContrato(Long contratoId);
	Double fazerAvaliacaoContratante(Double nota, Long contratanteId);
	Set<ContratoDTO> verTodosContratos(Long contratanteId);
	List<ContratanteDTO> listarContrantesBemAvaliados();
	
	
}
