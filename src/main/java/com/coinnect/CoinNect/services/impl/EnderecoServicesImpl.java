package com.coinnect.CoinNect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.entities.Endereco;
import com.coinnect.CoinNect.repositories.EnderecoRepositories;
import com.coinnect.CoinNect.services.EnderecoServices;

@Service
public class EnderecoServicesImpl implements EnderecoServices {

	@Autowired
	private EnderecoRepositories enderecoRepository;

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
	public EnderecoDTO findById(Long enderecoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarTodosEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarEndereco(Long enderecoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularDistancia(Long enderecoA, Long enderecoB) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EnderecoDTO> buscarEnderecosProximos(double latitude, double longitude, double raio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarEndereco(EnderecoDTO enderecoDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EnderecoDTO buscarCoordenadas(String enderecoCompleto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoDTO buscarEnderecoPorCoordenadas(double latitude, double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

}
