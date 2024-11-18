package com.coinnect.CoinNect.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.regex.Pattern;

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
        System.out.println("CNPJ limpo: " + cnpjLimpo); // Log do CNPJ limpo para depuração

        // URL da API da ReceitaWS para consultar o CNPJ
        String url = "https://receitaws.com.br/v1/cnpj/" + cnpjLimpo;

        // Instancia o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Cabeçalhos da requisição com o token de autenticação
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + receitaWsToken);
        HttpEntity<String> entidade = new HttpEntity<>(headers);

        // Faz a requisição GET para a API da ReceitaWS
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entidade, String.class);

        // Verificar a resposta
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            String responseBody = response.getBody();           
            if (responseBody.contains("OK")) {
            	return true;
                } else {
                    return false; // CNPJ não está ativo
                }
            } else {
                System.out.println("CNPJ não encontrado ou não tem a situação válida.");
                return false;
            }
        }
}
