package com.coinnect.CoinNect.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.entities.Endereco;
import com.coinnect.CoinNect.model.entities.Prestador;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.EnderecoRepositories;
import com.coinnect.CoinNect.repositories.PrestadorRepositories;
import com.coinnect.CoinNect.services.EnderecoServices;

@Service
public class EnderecoServicesImpl implements EnderecoServices {

	@Autowired
	private EnderecoRepositories enderecoRepository;

	@Autowired
	private PrestadorRepositories prestadorRepository;

	@Autowired
	private ContratanteRepositories contratanteRepository;

	@Autowired
	private OpenRouteServicesImpl openRouteServicesImpl;

	@Override
	public EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco) throws Exception {
		if (novoEndereco.getLatitude() == 0.0 && novoEndereco.getLongitude() == 0.0) {
			throw new Exception("Endereco não pode ser salvo, pois não foi marcado um ponto exato");
		}
		if (novoEndereco.getRua() == null && novoEndereco.getBairro() == null && novoEndereco.getNumero() == null) {
			throw new Exception("Campos rua, bairro e numero vewm ser preenchdios");
		}
		Endereco endereco = enderecoRepository.save(MyMapper.parseObject(novoEndereco, Endereco.class));
		return MyMapper.parseObject(endereco, EnderecoDTO.class);
	}

	@Override
	public EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente) {
		var existente = enderecoRepository.findById(enderecoExistente);
		if(!existente.isPresent()) throw new ResourceNotFoundException("Endereco não encontrado com ID" + enderecoExistente);
		Endereco end = existente.get();
		end.setBairro(update.getBairro());
		end.setLatitude(update.getLatitude());
		end.setLongitude(update.getLongitude());
		end.setNumero(update.getNumero());
		end.setRua(update.getRua());
		enderecoRepository.save(end);
		return MyMapper.parseObject(end, EnderecoDTO.class);
	}

	@Override
	public void deletarEnderecoExistente(Long idEndereco) {
		var existent = enderecoRepository.findById(idEndereco);
		if(!existent.isPresent()) throw new ResourceNotFoundException("Endereco não encontrado com ID" + idEndereco);
		enderecoRepository.delete(existent.get());
	}

	@Override
	public EnderecoDTO associarEnderecoContratante(String cnpjContratante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoDTO associarEnderecoPrestador(String cpfPrestador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularDistanciaEntreUsuarios(Long prestadorId, Long contratanteId) {
		Contratante prestador = contratanteRepository.findById(prestadorId)
				.orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com ID: " + prestadorId));
		Prestador contratante = prestadorRepository.findById(contratanteId).orElseThrow(
				() -> new ResourceNotFoundException("Contratante não encontrado com ID: " + contratanteId));

		double prestadorLat = prestador.getEndereco().getLatitude();
		double prestadorLong = prestador.getEndereco().getLongitude();
		double contratanteLat = contratante.getEndereco().getLatitude();
		double contratanteLong = contratante.getEndereco().getLongitude();

		return openRouteServicesImpl.getDistance(prestadorLat, prestadorLong, contratanteLat, contratanteLong);

	}

	// LISTAR TODOS OS ENDEREÇOS MAIS PROXIMOS 

}
