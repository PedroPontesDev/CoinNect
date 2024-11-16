package com.coinnect.CoinNect.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;
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

}
