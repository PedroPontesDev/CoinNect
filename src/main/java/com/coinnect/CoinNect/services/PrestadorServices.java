package com.coinnect.CoinNect.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;

public interface PrestadorServices {

	PrestadorDTO registrarPrestadorPorCpf(PrestadorDTO novoPrestador) throws Exception; 
	ContratoDTO analisarContratoDeContratante(Long contratoId, Long contratanteId) throws Exception;
	Double fazerAvaliacaoPrestador(Double nota, Long contratanteId) throws Exception;
	Set<ContratoDTO> verTodosContratos(Long contratanteId) throws Exception;
	List<PrestadorDTO> listarPrestadoresBemAvaliados() throws Exception;
	List<PrestadorDTO> listarPrestadorMalAvaliados() throws Exception;
	List<PrestadorDTO> listarTodos() throws Exception;
	ContratoDTO visualizarContratosProprios(Long contratoId, Long prestadorId) throws Exception;
	List<ContratoDTO> visualizarContratosAtivos(Long prestadorId);
	List<ContratoDTO> visualizarMeusContratosPresentes(Long prestadorId);
	PrestadorDTO anlisarPropostaByContrato(Long contratoId, LocalDate tempoDeAnlise);
	void negarContrar(Long id);
	 
}
