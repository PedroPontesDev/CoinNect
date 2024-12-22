package com.coinnect.CoinNect.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.exceptions.UnsoportedEvaluationException;
import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.entities.Contrato;
import com.coinnect.CoinNect.model.entities.Prestador;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.ContratoRepositories;
import com.coinnect.CoinNect.repositories.PrestadorRepositories;
import com.coinnect.CoinNect.services.ContratanteServices;

@Service
public class ContratanteServicesImpl implements ContratanteServices {

	@Autowired
	private ContratanteRepositories contratanteRepository;

	@Autowired
	private PrestadorRepositories prestadorRepository;

	@Autowired
	private ContratoRepositories contratoRepository;

	@Autowired
	private CnpjValidatorServices cnpjValidator;

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
	public ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) throws Exception {
		Contrato novoContrato = MyMapper.parseObject(ofertaContrato, Contrato.class);
		Prestador prestador = prestadorRepository.findById(prestadorId)
				.orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com ID" + prestadorId));
		if (novoContrato != null) {
			novoContrato.setStatus(StatusContrato.OFERTADO);
			novoContrato.setPrestador(prestador);
			return MyMapper.parseObject(novoContrato, ContratoDTO.class);
		} else {
			throw new Exception("Erro ao criar contrato, verifique os dados fornecidos.");
		}

	}

	@Override
	public List<ContratanteDTO> listarContrantesBemAvaliados() {
		var bemAvaliados = contratanteRepository.findAll().stream()
				.sorted(Comparator.comparing(c -> ((Contratante) c).getAvalicao()).reversed())
				.collect(Collectors.toList()); // Depois trocar por algum algoritmo como QuickSort ou usar JPQL
		return MyMapper.parseListObjects(bemAvaliados, ContratanteDTO.class);
	}

	@Override
	public ContratoDTO visualizarContratosProprios(Long contratoId, Long contratanteId) throws Exception {
		var contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com o ID" + contratoId));

		var contratante = contratanteRepository.findById(contratanteId).orElseThrow(
				() -> new ResourceNotFoundException("Contratante não encontrado com o ID" + contratanteId));
		;

		if (contrato.getContratante().equals(contratante))
			return MyMapper.parseObject(contrato, ContratoDTO.class);
		else {
			throw new Exception("Este contrato não pertence ao contratante fornecido.");
		}

	}

	@Override
	public BigDecimal fazerAvaliacaoContratante(Double notaParam, Long contratanteId) {
		// Busca o contratante no repositório
		var contratante = contratanteRepository.findById(contratanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Contratante não localizado com ID " + contratanteId));

		// Validação da nota
		if (notaParam >= contratante.getAVALICAO_MAXIMA().doubleValue() || notaParam < 0.0) {
			throw new UnsoportedEvaluationException("Nota deve estar entre 0.0 e " + contratante.getAVALICAO_MAXIMA());
		}

		// Conversão para BigDecimal
		BigDecimal nota = BigDecimal.valueOf(notaParam);
		BigDecimal totalAvaliacoes = BigDecimal.valueOf(contratante.getTotalAvaliacoes());

		// Cálculo da nova média
		BigDecimal novaMedia;
		if (contratante.getAvalicao() == null) {
			novaMedia = nota; // Primeira avaliação caso nao tenha

		} else {
			novaMedia = contratante.getAvalicao().multiply(totalAvaliacoes)
												.add(BigDecimal.valueOf(notaParam))
												.divide(totalAvaliacoes, RoundingMode.HALF_UP);

		}
		// Atualiza a avaliação do contratante
		contratante.setAvalicao(novaMedia);
		contratante.setTotalAvaliacoes(contratante.getTotalAvaliacoes() + 1);
		contratanteRepository.save(contratante);

		return novaMedia; // Retorna a nova média calculada
	}

	public Set<ContratoDTO> verTodosContratos(Long contratanteId) {
		var contratante = contratanteRepository.findById(contratanteId).orElseThrow(
				() -> new ResourceNotFoundException("Contratante não encontrado com o ID" + contratanteId));
		if (contratante.getContratos().isEmpty())
			throw new ResourceNotFoundException("Você não tem contratos para visualizar!");

		return contratante.getContratos().stream().map(contratos -> MyMapper.parseObject(contratos, ContratoDTO.class))
				.collect(Collectors.toSet());
	}

	@Override
	public List<ContratanteDTO> listarContrantesMalAvaliados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratanteDTO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratanteDTO findById(Long contratanteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> visualizarContratosAtivos(Long contratanteId) {
		var contratante = contratanteRepository.findById(contratanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Contratante não encontrado com ID" + contratanteId));

		List<ContratoDTO> contratosAtivos = new ArrayList<>();

		for (Contrato contrato : contratante.getContratos()) {
			if (contrato.getStatus() == StatusContrato.ATIVO) {
				contratosAtivos.add(MyMapper.parseObject(contrato, ContratoDTO.class));
			}
		}

		if (contratosAtivos.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum contrato ativo encontrado para este contratante.");
		}
		return contratosAtivos;

	}

}
