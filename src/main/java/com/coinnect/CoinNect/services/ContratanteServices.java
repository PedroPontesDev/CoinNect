package com.coinnect.CoinNect.services;

import java.util.List;
import java.util.Set;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.enums.StatusContrato;

public interface ContratanteServices {

	ContratanteDTO registrarContrantePorCpf(ContratanteDTO contratante) throws Exception; 
	ContratanteDTO registrarContrantePorCnpj(ContratanteDTO contratanteCnpj) throws Exception;
	ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) throws Exception;
	Double fazerAvaliacaoContratante(Double nota, Long contratanteId) throws Exception;
	Set<ContratoDTO> verTodosContratos(Long contratanteId) throws Exception;
	List<ContratanteDTO> listarContrantesBemAvaliados() throws Exception;
	List<ContratanteDTO> listarContrantesMalAvaliados() throws Exception;
	List<ContratanteDTO> listarTodos() throws Exception;
	ContratanteDTO findById(Long contratanteId) throws Exception;
	ContratoDTO visualizarContratosProprios(Long contratoId, Long contratanteId) throws Exception;
	List<ContratoDTO> visualizarContratosAtivos(Long contratanteId);
	
	
	
}
