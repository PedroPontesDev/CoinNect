package com.coinnect.CoinNect.services.impl;

import java.net.http.HttpHeaders;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CnpjValidatorServices {

	@Value(value = "${receitaws.token}")
	private String receitaWsToken;

	public boolean validarCnpj(String cnpj) throws Exception {
		// Regex para validar CNPJ com e sem máscara
		String cnpjRegex = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
		String cnpjSemMascaraRegex = "^\\d{14}$";
		if (cnpj == null || (!Pattern.matches(cnpjRegex, cnpj) && !Pattern.matches(cnpjSemMascaraRegex, cnpj))) {
			throw new Exception("CNPJ inválido! O CNPJ deve estar no formato correto.");
		}

		// Remover a máscara do CNPJ para enviar na API
		String cnpjLimpo = cnpj.replaceAll("[^0-9]", "");

		// URL da API da ReceitaWS para consultar o CNPJ
		String url = "https://receitaws.com.br/v1/cnpj/" + cnpjLimpo;

		// Instancia o RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Cabeçalhos da requisição com o token de autenticação
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set("Authorization", "Bearer " + receitaWsToken);
		HttpEntity<String> entidade = new HttpEntity<>(headers);

		// Faz a requisição GET para a API da ReceitaWS
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entidade, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			String responseBody = response.getBody();
			if (responseBody.contains("\"status\":\"OK\"")) {
				// Se a resposta for "OK", o CNPJ existe
				return true;
			} else {
				// Caso a resposta não seja OK, significa que o CNPJ não foi encontrado
				return false;
			}
		} else {
			throw new Exception("Erro ao consultar CNPJ na ReceitaWS. Status: " + response.getStatusCode());
		}
	}

}
