package com.coinnect.CoinNect.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.entities.Contrato;
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
		if (!cnpjValido) {
			throw new Exception("Cnpj não pode ser confirmado!");
		} else if (contratanteCnpj.getCpf() != null) {
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
	public List<ContratanteDTO> listarContrantesBemAvaliados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratoDTO visualizarContrato(Long contratoId) {
		var contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com o ID" + contratoId));
		return MyMapper.parseObject(contrato, ContratoDTO.class);

	}

	@Override
	public Double fazerAvaliacaoContratante(Double nota, Long contratanteId, Long prestadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<ContratoDTO> verTodosContratos(Long contratanteId) {
		var contratante = contratanteRepository.findById(contratanteId).orElseThrow(
				() -> new ResourceNotFoundException("Contratante não encontrado com o ID" + contratanteId));
		if (contratante.getContratos().isEmpty()) throw new ResourceNotFoundException("Você não tem contratos para visualizar!");
		
		 return contratante.getContratos()
					.stream()
					.map(contratos -> MyMapper.parseObject(contratos, ContratoDTO.class))
					.collect(Collectors.toSet());
	}

}
