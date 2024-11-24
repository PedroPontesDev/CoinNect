package com.coinnect.CoinNect.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;
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
	
	@Autowired
	private ContratoServicesImpl contratoServices;  //Servicos que estao disponiveis a prestadores!

	//Implementar CateogiraServices
	
	
	@Override
	public PrestadorDTO registrarPrestadorPorCpf(PrestadorDTO novoPrestador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO analisarContratoDeContratante(Long contratoId, Long contratanteId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double fazerAvaliacaoPrestador(Double nota, Long contratanteId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ContratoDTO> verTodosContratos(Long contratanteId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrestadorDTO> listarPrestadoresBemAvaliados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrestadorDTO> listarPrestadorMalAvaliados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrestadorDTO> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO visualizarContratosProprios(Long contratoId, Long prestadorId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> visualizarContratosAtivos(Long prestadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrestadorDTO anlisarPropostaByContrato(Long contratoId, LocalDate tempoDeAnlise) {
		// TODO Auto-generated method stub
		return null;
	}

}
