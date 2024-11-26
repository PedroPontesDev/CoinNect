package com.coinnect.CoinNect.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;
import com.coinnect.CoinNect.model.entities.Contrato;

public interface PrestadorServices {

	PrestadorDTO registrarPrestadorPorCpf(PrestadorDTO contratante) throws Exception; ;
	ContratoDTO analisarOfertaDeContrante(Long contratanteId, Long contratoId) throws Exception;
	Double fazerAvaliacaoPrestador(Double nota, Long contratanteId) throws Exception;
	Set<ContratoDTO> verTodosPrestadores(Long prestadorId) throws Exception;
	List<ContratanteDTO> listarPrestadoresBemAvaliados() throws Exception;
	List<ContratanteDTO> listarPrestadoresMalAvaliados() throws Exception;
	List<ContratanteDTO> listarTodos() throws Exception;
	ContratanteDTO findById(Long contratanteId) throws Exception;
	ContratoDTO visualizarContratosProprios(Long contratoId, Long prestadorId) throws Exception;
	List<ContratoDTO> visualizarContratosAtivos();
	ContratoDTO analisarContrato(LocalDateTime comecoAalise, LocalDateTime expiracao, Contrato contrato);
	
	
}
