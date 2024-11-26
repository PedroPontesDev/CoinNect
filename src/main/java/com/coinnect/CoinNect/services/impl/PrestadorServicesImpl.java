package com.coinnect.CoinNect.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;
import com.coinnect.CoinNect.model.entities.Contrato;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.ContratoRepositories;
import com.coinnect.CoinNect.repositories.EnderecoRepositories;
import com.coinnect.CoinNect.services.PrestadorServices;

@Service
public class PrestadorServicesImpl implements PrestadorServices {

	@Autowired
	private EnderecoRepositories enderecoRepository;
	
	@Autowired
	private ContratanteRepositories contratanteRepository;
	
	@Autowired
	private ContratoRepositories contratoRepository;

	@Override
	public PrestadorDTO registrarPrestadorPorCpf(PrestadorDTO contratante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO analisarOfertaDeContrante(Long contratanteId, Long contratoId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double fazerAvaliacaoPrestador(Double nota, Long contratanteId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ContratoDTO> verTodosPrestadores(Long prestadorId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratanteDTO> listarPrestadoresBemAvaliados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratanteDTO> listarPrestadoresMalAvaliados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratanteDTO> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratanteDTO findById(Long contratanteId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO visualizarContratosProprios(Long contratoId, Long prestadorId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> visualizarContratosAtivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO analisarContrato(LocalDateTime comecoAalise, LocalDateTime expiracao, Contrato contrato) {
		// TODO Auto-generated method stub
		return null;
	}

	//mos aquio uma injecao de dependencia pra contrato server pois la contem umampla gama de funcionalidades
	
}