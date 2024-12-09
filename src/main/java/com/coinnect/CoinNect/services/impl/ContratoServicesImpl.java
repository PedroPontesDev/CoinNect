package com.coinnect.CoinNect.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinnect.CoinNect.exceptions.ContratoCannotBeCreatedException;
import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contrato;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.repositories.ContratanteRepositories;
import com.coinnect.CoinNect.repositories.ContratoRepositories;
import com.coinnect.CoinNect.repositories.PrestadorRepositories;
import com.coinnect.CoinNect.services.ContratoServices;
import com.coinnect.CoinNect.utils.PdfGenerator;

@Service
public class ContratoServicesImpl implements ContratoServices {

	@Autowired
	private ContratoRepositories contratoRepository;

	@Autowired
	private PrestadorRepositories prestadorRepository;

	@Autowired
	private ContratanteRepositories contratanteRepository;

	@Autowired
	private PdfGenerator pdfGen;

	@Override
	public ContratoDTO criarNovoContrato(ContratoDTO contratoNovo) {
		var novo = MyMapper.parseObject(contratoNovo, Contrato.class);
		if (novo != null) {
			return MyMapper.parseObject(contratoRepository.save(novo), ContratoDTO.class);
		}
		throw new ResourceNotFoundException(
				"Não foi possivel criar um novo contrato, revise os dados e tente novamente!");
	}

	@Override
	public ContratoDTO oferecerContratoPrestador(ContratoDTO ofertaContrato, Long prestadorId) {

		// Implementar ainda o contratante que estiver logado no contexto de segurança e
		// associalo ao contrato
		var contratante = contratanteRepository.findById(ofertaContrato.getContratanteId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Contratante não encontrado com ID" + ofertaContrato.getContratanteId()));
		var contrato = MyMapper.parseObject(ofertaContrato, Contrato.class);
		var prestador = prestadorRepository.findById(prestadorId).orElseThrow(
				() -> new ResourceNotFoundException("Prestador de serviço não encontrado com ID" + prestadorId));

		if (contrato != null) {
			contrato.setConteudo(ofertaContrato.getConteudo());
			contrato.setContratante(contratante);
			contrato.setPrestador(prestador);
			contrato.setStatus(StatusContrato.OFERTADO);
			contrato.setDataCriacao(LocalDate.now());
			contratoRepository.save(contrato);
			return MyMapper.parseObject(contrato, ContratoDTO.class);

		}
		throw new ResourceNotFoundException("Não foi possivel criar contrato, verifique os dados e tnte novamente!");
	}

	@Override
	public ContratoDTO aceitarContrato(Long contratoId) {
		var contrato = contratoRepository.findById(contratoId);
		Contrato contratoEntity = contrato.get();

		if (contratoEntity.getContratante() != null && contratoEntity.getPrestador() != null
				&& contratoEntity.getStatus().equals(StatusContrato.OFERTADO)) {
			contratoEntity.setStatus(StatusContrato.ACEITO);
			return MyMapper.parseObject(contratoRepository.save(contratoEntity), ContratoDTO.class);
		}
		throw new ResourceNotFoundException("Contrato não encontrado com ID" + contratoId);
	}

	@Override
	public void negarContrato(Long contratanteId, Long prestadorId, Long contratoId) {
		var contrato = contratoRepository.findById(contratoId);
		Contrato contratoEntity = contrato.get();

		if (contratoEntity.getContratante() != null && contratoEntity.getPrestador() != null
				&& contratoEntity.getStatus().equals(StatusContrato.OFERTADO)) {
			contratoEntity.setStatus(StatusContrato.NEGADO);
			contratoRepository.save(contratoEntity);
		}
		throw new ResourceNotFoundException("Contrato não encontrado com ID" + contratoId);
	}

	@Override
	public ContratoDTO formalizarContrato(Long contratanteId, Long prestadorId, Long contratoId,
			String assinaturaPrestador, String assinaturaContratante) {
		var contratante = contratanteRepository.findById(contratanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Contratante não encontrado com ID" + contratanteId));
		var prestador = prestadorRepository.findById(prestadorId)
				.orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com ID" + prestadorId));
		var contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com ID" + contratoId));

		if (contrato.getStatus().equals(StatusContrato.OFERTADO)) {
			if (assinaturaPrestador == null || assinaturaContratante == null) {
				throw new ContratoCannotBeCreatedException(
						"Ambas as assinaturas são necessárias para formalizar o contrato.");
			}

			contrato.setAssinaturaContratante(assinaturaContratante);
			contrato.setAssinaturaPrestador(assinaturaPrestador);
			contrato.setDataInicio(LocalDate.now());
			contrato.setPrestador(prestador);
			contrato.setContratante(contratante);
			contrato.setFoiFormalizado(true);
			contrato.setStatus(StatusContrato.ATIVO);
			contratoRepository.save(contrato);
			return MyMapper.parseObject(contrato, ContratoDTO.class);

		}
		throw new ContratoCannotBeCreatedException(
				"Contrato não pôde ser formalizado pois o contrato não foi ofertado");
	}

	@Override
	public void deletarContrato(Long contratoId) {
		var contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com ID" + contratoId));
		contratoRepository.delete(contrato);

	}

	/*
	 * Metodos a partir daqui serão processados no banco de dados!
	 * 
	 * Metodo de analise de proposta deve ser criado deixando em analise por no
	 * maximo DOIS DIAS
	 */

	@Override
	public Set<ContratoDTO> procurarContratoPorData(LocalDate dataInicio, LocalDate dataTermino) {
		var query = contratoRepository.findByDataInicioAndDataTermino(dataInicio, dataTermino);

		return query.stream().map(c -> MyMapper.parseObject(c, ContratoDTO.class)).collect(Collectors.toSet());

	}

	@Override
	public Set<ContratoDTO> procurarContratosMaisCaros(BigDecimal minimo) {
		var ordenados = contratoRepository.findByValorMaximo(minimo).stream()
				.map(c -> MyMapper.parseObject(c, ContratoDTO.class)).collect(Collectors.toSet());
		return ordenados;
	}

	@Override
	public List<ContratoDTO> procurarContratosPorStatus(String status) {
		if (status == null || status.isEmpty()) {
			throw new ResourceNotFoundException("O valor não pode ser nulo ou vazio!");
		}
		try {
			StatusContrato statusContrato = StatusContrato.valueOf(status.toUpperCase());

			return contratoRepository.findByStatus(statusContrato).stream()
					.map(c -> MyMapper.parseObject(c, ContratoDTO.class)).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException("Status não encontrado: " + status);
		}

	}

	@Override
	public boolean verificarExistenciaContrato(Long contratanteId, Long prestadorId) {
		var contratoExiste = contratoRepository.verificarContratoExiste(contratanteId, prestadorId);
		if (contratoExiste)
			return true;
		throw new ResourceNotFoundException("Contrato inexistente verifique os dados e tente novamente!");
	}

	@Override
	public ContratoDTO atualizarTermosContrato(Long contratoId, BigDecimal novoValor, String novosTermos) {
		var contrato = contratoRepository.findById(contratoId);
		if (contrato.isPresent()) {
			Contrato c = contrato.get();
			if (!c.foiFormalizado()) {
				c.setValor(novoValor);
				c.setConteudo(novosTermos);
				contratoRepository.save(c);
				return MyMapper.parseObject(c, ContratoDTO.class);
			}

		}
		throw new ResourceNotFoundException("Não foi possivel atualizar o contrato de ID " + contratoId
				+ ", verifique os dados e tente novamente!");
	}

	@Override
	public List<ContratoDTO> procurarContratosVencidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratoDTO> procurarContratosPendentesDeAssinatura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal calcularTotalContratos(Long contratanteId) {
		return null;
	}

	@Override
	public ContratoDTO renovarContrato(Long contratoId, LocalDate novaDataTermino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelarContrato(Long contratoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] gerarContratoFormalizadoPDF(Long contratoId) {
		var contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado" + contratoId));
		if (contrato.foiFormalizado()) {
			try {
				return pdfGen.gerarPedfSeFormalizado(contrato);
			} catch (ContratoCannotBeCreatedException e) {
				throw new ContratoCannotBeCreatedException("Contrato não pode ser gerado");
			}
		}
		throw new ContratoCannotBeCreatedException("Contrato não foi formalizado ainda!");

	}

	@Override
	public void inativarContaratoSeFormalizado(Long contratoId, String status) {
		Contrato contrato = contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ResourceNotFoundException("Contraato não encontrado"));
		try {
			StatusContrato statusContrato = StatusContrato.valueOf(status.toUpperCase());

			if (contrato.getStatus().equals(StatusContrato.ATIVO) && contrato.foiFormalizado()) {
				if (statusContrato == StatusContrato.INATIVO) {
					contrato.setStatus(statusContrato);
					contratoRepository.save(contrato);
				} else {
					throw new IllegalArgumentException("\"O status fornecido não é válido para inativação.\"");
				}
			} else {
				throw new ResourceNotFoundException(
						"Contrato não pode ser inativado pois não está ativo ou não foi formalizado.");
			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Status invalido para a operação do contrato com ID " + contratoId);
		}

	}

}
