package com.coinnect.CoinNect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;
import com.coinnect.CoinNect.model.entities.Endereco;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.EnderecoRepositories;
import com.coinnect.CoinNect.services.EnderecoServices;

@Service
public class EnderecoServicesImpl implements EnderecoServices {

	@Autowired
	private EnderecoRepositories enderecoRepository;
	
	@Autowired
	private ContratanteRepositories contratanteRepository;

	@Override
	public EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarEnderecoExistente(Long idEndereco) {
		// TODO Auto-generated method stub
		
	}
}
