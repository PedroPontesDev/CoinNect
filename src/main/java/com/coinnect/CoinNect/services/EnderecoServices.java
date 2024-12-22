package com.coinnect.CoinNect.services;

import com.coinnect.CoinNect.model.dtos.EnderecoDTO;

public interface EnderecoServices {


	EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco) throws Exception;
	EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente)  throws Exception;
	EnderecoDTO associarEnderecoContratante(String cnpjContratante)  throws Exception;
	EnderecoDTO associarEnderecoPrestador(String cpfPrestador)  throws Exception;
	void deletarEnderecoExistente(Long idEndereco)  throws Exception; 
	double calcularDistanciaEntreUsuarios(Long prestadorId, Long contratanteId)  throws Exception;;
	
	
	
}
