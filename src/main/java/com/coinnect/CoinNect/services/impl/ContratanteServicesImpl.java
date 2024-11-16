package com.coinnect.CoinNect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.ContratoRepositories;
import com.coinnect.CoinNect.repositories.PrestadorRepositories;
import com.coinnect.CoinNect.services.ContratanteServices;

public class ContratanteServicesImpl implements ContratanteServices {

	@Autowired
	private ContratanteRepositories contratanteRepository;

	@Autowired
	private PrestadorRepositories prestadorRepository;

	@Autowired
	private ContratoRepositories contratoRepository;

	@Autowired
	private CnpjValidatorServices cnpjValidator;
	
	@Autowired
	private ContratoServicesImpl contratoServices;

	@Value(value = "${receitaws.token}")
	private String receitaWsToken;

	@Override
	public ContratanteDTO registrarContrantePorCpf(ContratanteDTO contratante) throws Exception {
		if (contratante.getCnpj() != null)
			throw new Exception("Você está cadastrando por CPF, operação não pôde ser concluida!");
		var contra = MyMapper.parseObject(contratante, Contratante.class);
		return null;
	}

	@Override
	public ContratanteDTO registrarContrantePorCnpj(ContratanteDTO contratanteCnpj) throws Exception {
		boolean cnpjValido = cnpjValidator.validarCnpj(contratanteCnpj.getCnpj());
		if(!cnpjValido) {
			throw new Exception("Cnpj não pode ser confirmado!");
		} else if(contratanteCnpj.getCpf() != null) {
			throw new Exception("Erro, cadastro foi escolhido como CNPJ!");
		}
		var contratante = MyMapper.parseObject(contratanteCnpj, Contratante.class);
		contratanteRepository.save(contratante);
		return MyMapper.parseObject(contratante, ContratanteDTO.class);

	}

	@Override
	public ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) {
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
