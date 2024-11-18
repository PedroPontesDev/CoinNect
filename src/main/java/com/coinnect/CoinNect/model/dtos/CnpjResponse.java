package com.coinnect.CoinNect.model.dtos;

public class CnpjResponse {

	private String situacao;

	public CnpjResponse(String situacao) {
		this.situacao = situacao;
	}

	// Getters e Setters
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
