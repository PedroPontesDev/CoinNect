package com.coinnect.CoinNect.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.enums.StatusContrato;

public interface ContratoServices {

	ContratoDTO criarNovoContrato(ContratoDTO contratoNovo);
	ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId);
	ContratoDTO aceitarContrato(Long contratoId);
	void negarContrato(Long contratanteId, Long prestadorId, Long contratoId);
	ContratoDTO formalizarContrato(Long contratanteId, Long prestadorId, Long contratoId, String assinaturaPrestador,
			String assinaturaContratante);
	void inativarContaratoSeFormalizado(Long contratoId, String status);
	Set<ContratoDTO> procurarContratoPorData(LocalDate dataInicio, LocalDate dataTermino);
	Set<ContratoDTO> procurarContratosMaisCaros(BigDecimal valor);
	void deletarContrato(Long contratoId);
	List<ContratoDTO> procurarContratosPorStatus(String status);
	boolean verificarExistenciaContrato(Long contratanteId, Long prestadorId);
	ContratoDTO atualizarTermosContrato(Long contratoId, BigDecimal novoValor, String novosTermos);
	List<ContratoDTO> procurarContratosVencidos();
	List<ContratoDTO> procurarContratosPendentesDeAssinatura();
	BigDecimal calcularTotalContratos(Long contratanteId);
	ContratoDTO renovarContrato(Long contratoId, LocalDate novaDataTermino);
	void cancelarContrato(Long contratoId);
	byte[] gerarContratoFormalizadoPDF(Long contratoId);

}
