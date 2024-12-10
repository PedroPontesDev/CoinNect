package com.coinnect.CoinNect.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.entities.Prestador;
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

	@Override
	public double calcularDistanciaEntreUsuarios(Long prestadorId, Long contratanteId) {
        Prestador prestador = prestadorRepository.findById(prestadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com ID: " + prestadorId));
        Contratante contratante = contratanteRepository.findById(contratanteId)
                .orElseThrow(() -> new ResourceNotFoundException("Contratante não encontrado com ID: " + contratanteId));

        double prestadorLat = prestador.getEndereco().getLatitude();
        double prestadorLong = prestador.getEndereco().getLongitude();
        double contratanteLat = contratante.getEndereco().getLatitude();
        double contratanteLong = contratante.getEndereco().getLongitude();
        
        return openRouteServicesImpl.getDistance(prestadorLat, prestadorLong, contratanteLat, contratanteLong);
	}
}
