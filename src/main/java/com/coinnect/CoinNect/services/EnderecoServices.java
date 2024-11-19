package com.coinnect.CoinNect.services;

import java.util.List;

import com.coinnect.CoinNect.model.dtos.EnderecoDTO;
import com.coinnect.CoinNect.model.entities.Endereco;

public interface EnderecoServices {
	
	// Crud
	EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco);
    EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente);
    EnderecoDTO findById(Long enderecoId);
    List<Endereco> listarTodosEndereco();
    void deletarEndereco(Long enderecoId);
    
    
    // Distância e localização
    double calcularDistancia(Long enderecoA, Long enderecoB);
    List<EnderecoDTO> buscarEnderecosProximos(double latitude, double longitude, double raio);
    
    // Validação e Geocodificação
    boolean validarEndereco(EnderecoDTO enderecoDTO);
    EnderecoDTO buscarCoordenadas(String enderecoCompleto);
    EnderecoDTO buscarEnderecoPorCoordenadas(double latitude, double longitude);
    
    // Outras Regras de Negocio
    
    
}
