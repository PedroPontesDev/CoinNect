package com.coinnect.CoinNect.services.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;

import com.coinnect.CoinNect.model.dtos.ContratanteDTO;
import com.coinnect.CoinNect.model.dtos.ContratoDTO;
import com.coinnect.CoinNect.model.entities.Contratante;
import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.coinnect.CoinNect.model.mapper.MyMapper;
import com.coinnect.CoinNect.services.ContratanteServices;

public class ContratanteServicesImpl implements ContratanteServices {

	// IMPLEEMENTAR REPOSITORIO DE CONTRATANTE

	// IMPLEMENTAR REPOSITORIO DE PRESTADOR DE SERVIÇOS

	// IMPLEMENTAR REPOSITORIO DE CONTRATOS

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
		// Regex para validar CNPJ com e sem máscara
		String cnpjRegex = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
		String cnpjSemMascaraRegex = "^\\d{14}$";

		// Validação do formato do CNPJ
		if (contratanteCnpj.getCnpj() == null || (!Pattern.matches(cnpjRegex, contratanteCnpj.getCnpj())
				&& !Pattern.matches(cnpjSemMascaraRegex, contratanteCnpj.getCnpj()))) {
			throw new Exception("CNPJ inválido! O CNPJ deve estar no formato correto.");
		} else if (contratanteCnpj.getCpf() != null) {
			throw new Exception("Você está fazendo um cadastro com CNPJ, CPF não é válido!");
		}
		
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
