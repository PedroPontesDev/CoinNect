package com.coinnect.CoinNect.services.impl;

import java.util.List;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.services.ContratanteServices;

public class ContratanteServicesImpl implements ContratanteServices {

	//IMPLEEMENTAR REPOSITORIO DE CONTRATANTE
	
	//IMPLEMENTAR REPOSITORIO DE PRESTADOR DE SERVIÇOS
	
	//IMPLEMENTAR REPOSITORIO DE CONTRATOS
	
	
	@Override
	public ContratanteDTO registrarContrantePorCpf(ContratanteDTO contratante) throws Exception {
		if(contratante.getCnpj() != null) throw new Exception("Você está cadastrando por CPF, operação não pôde ser concluida!");
		var contra = MyMapper.parseObject(contratante, Contratante.class);
		return null;
	}

	@Override
	public ContratanteDTO registrarContrantePorCnpj(ContratanteDTO contratanteCnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double fazerAvaliacaoContratante(Double nota, Long contratanteId, Long prestadorId, StatusContrato status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratanteDTO> listarContrantesBemAvaliados() {
		// TODO Auto-generated method stub
		return null;
	}

}
