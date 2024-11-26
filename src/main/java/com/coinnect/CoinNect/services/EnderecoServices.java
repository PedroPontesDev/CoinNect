package com.coinnect.CoinNect.services;

import com.coinnect.CoinNect.model.dtos.EnderecoDTO;

public interface EnderecoServices {


	EnderecoDTO registrarNovoEndereco(EnderecoDTO novoEndereco);
	EnderecoDTO atualizarEnderecoExistente(EnderecoDTO update, Long enderecoExistente);
	void deletarEnderecoExistente(Long idEndereco);
	



	//Algumas funçoes daqui sera utilizadas APIS de GeoDistance e Açguns Algortimos

	
	
}
