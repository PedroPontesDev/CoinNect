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

@Service
public class ContratoServicesImpl implements ContratoServices {

	@Autowired
	private ContratoRepositories contratoRepository;

	@Autowired
	private PrestadorRepositories prestadorRepository;

	@Autowired
	private ContratanteRepositories contratanteRepository;

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
		var contrato = MyMapper.parseObject(ofertaContrato, Contrato.class);
		var prestador = prestadorRepository.findById(prestadorId).orElseThrow(
				() -> new ResourceNotFoundException("Prestador de serviço não encontrado com ID" + prestadorId));

		if (contrato != null) {
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
			contrato.setStatus(StatusContrato.ATIVO);
			contratoRepository.save(contrato);
			return MyMapper.parseObject(contrato, ContratoDTO.class);

		}
		throw new ContratoCannotBeCreatedException("Contrato não pôde ser formalizado pois o contrato não foi ofertado");
	}

	/* Metodos a partir daqui serão processados no banco de dados!

	 Metodo de analise de proposta deve ser criado deixando em analise por no maximo DOIS DIAS */

	@Override
	public Set<ContratoDTO> procurarContratoPorData(LocalDate dataInicio, LocalDate dataTermino) {
		var query = contratoRepository.findByDataInicioAndDataTermino(dataInicio, dataTermino);
		
		return query.
					stream()
					.map(c -> MyMapper.parseObject(c, ContratoDTO.class))
					.collect(Collectors.toSet());
		
	}

	@Override
	public Set<ContratoDTO> procurarContratosMaisCaros(BigDecimal valor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void deletarContrato(Long contratoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ContratoDTO> procurarContratosPorStatus(StatusContrato status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarExistenciaContrato(Long contratanteId, Long prestadorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContratoDTO atualizarContrato(Long contratoId, BigDecimal novoValor, String novosTermos) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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
	public List<ContratoDTO> procurarHistoricoAlteracoes(Long contratoId) {
		// TODO Auto-generated method stub
		return null;
	}


}
