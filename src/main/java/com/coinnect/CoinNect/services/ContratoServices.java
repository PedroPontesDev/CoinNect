package com.coinnect.CoinNect.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;

public interface ContratoServices {

	ContratoDTO criarNovoContrato(ContratoDTO contratoNovo);
	ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId);
	ContratoDTO aceitarContrato(Long contratanteId, Long prestadorId, Long contratoId);
	void negarContrato(Long contratanteId, Long prestadorId, Long contratoId);
	ContratoDTO formalizarContrato(Long contratanteId, Long prestadorId, Long contratoId, String assinaturaPrestador, String assinaturaContratante);
	ContratoDTO procurarContratoPorData(LocalDate dataInicio, LocalDate dataTermino);
	ContratoDTO procurarContratosMaisCaros(BigDecimal valor);
	void deletarContrato(Long contratoId);
	
	
	
}
