package com.coinnect.CoinNect.services;

import com.coinnect.CoinNect.model.dtos.EnderecoDTO;

public interface EnderecoServices {


	EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco);
	EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente);
	void deletarEnderecoExistente(Long idEndereco);
	double calcularDistanciaEntreUsuarios(Long prestadorId, Long contratanteId);
	
	
}
