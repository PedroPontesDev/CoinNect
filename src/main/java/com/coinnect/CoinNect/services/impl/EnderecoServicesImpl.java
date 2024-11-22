package com.coinnect.CoinNect.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.dtos.PrestadorDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
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
		if(novoEndereco != null) {
			var end = MyMapper.parseObject(novoEndereco, Endereco.class);
			enderecoRepository.save(end);
		} throw new ResourceNotFoundException("Endereco não pode ser nulo!");
	}

	@Override
	public EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente) {
		var endExistente = enderecoRepository.findById(enderecoExistente);
		if(endExistente != null) {
			var end = endExistente.get();
			end.setBairro(update.getBairro());
			end.setRua(update.getRua());
			end.setNumero(update.getNumero());
			end.setLongitude(update.getLongitude());
			end.setLatitude(update.getLatitude());
			enderecoRepository.save(end);
			return MyMapper.parseObject(end, EnderecoDTO.class);
		} throw new ResourceNotFoundException("Não foi possivel atualizar endereço, verifique os dados fornecidos e tente novamente!");
	}

	@Override
	public EnderecoDTO findById(Long enderecoId) {
		var end = enderecoRepository.findById(enderecoId);
		if(end.isPresent()) {
			return MyMapper.parseObject(end, EnderecoDTO.class);
		} throw new ResourceNotFoundException("Não foi possivel localizar o endereco com o ID" + enderecoId);
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

	@Override
	public ContratanteDTO findContratanteByEndereco(String rua, Integer numero) {
		var contratante = contratanteRepository.findByEndereco(rua, numero);
		if(contratante != null) {
			var contratanteEntity = contratante;
			return MyMapper.parseObject(contratanteEntity, ContratanteDTO.class);
		} throw new ResourceNotFoundException("Não foi possivel localizar nenhum contrantate neste endereco!");
	}

	@Override
	public PrestadorDTO findPrestadorByEndereco(String rua, Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
