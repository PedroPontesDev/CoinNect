package com.coinnect.CoinNect.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.repositories.ContratoRepositories;
import com.coinnect.CoinNect.services.ContratoServices;

@Service
public class ContratoServicesImpl implements ContratoServices {

	@Autowired
	private ContratoRepositories contratoRepository;
	
	//A IMPLEMENTAR REPOSITORIOS DE PRESTADORES, CONTRATANTES
	
	@Override
	public ContratoDTO criarNovoContrato(ContratoDTO contratoNovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO aceitarContrato(Long contratanteId, Long prestadorId, Long contratoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void negarContrato(Long contratanteId, Long prestadorId, Long contratoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContratoDTO formalizarContrato(Long contratanteId, Long prestadorId, Long contratoId,
			String assinaturaPrestador, String assinaturaContratante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO procurarContratoPorData(LocalDate dataInicio, LocalDate dataTermino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO procurarContratosMaisCaros(BigDecimal valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarContrato(Long contratoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ContratoDTO> procurarContratosPorStatus(StatusContrato status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarExistenciaContrato(Long contratanteId, Long prestadorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContratoDTO atualizarContrato(Long contratoId, BigDecimal novoValor, String novosTermos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> procurarContratosVencidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> procurarContratosPendentesDeAssinatura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal calcularTotalContratos(Long contratanteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO renovarContrato(Long contratoId, LocalDate novaDataTermino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelarContrato(Long contratoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ContratoDTO> procurarHistoricoAlteracoes(Long contratoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
