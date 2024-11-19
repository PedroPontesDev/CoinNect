package com.coinnect.CoinNect.model.dtos;

public class EnderecoDTO {

	private Long id;

	private String rua;
	private String bairro;
	private Integer numero;
	private double latitude;
	private double longitude;

	public EnderecoDTO(Long id, String rua, String bairro, Integer numero, double latitude, double longitude) {
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public EnderecoDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
