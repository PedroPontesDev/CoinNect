package com.coinnect.CoinNect.model.entities;

import com.coinnect.CoinNect.model.enums.TipoDeServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_perfil_contratantes")
public class PerfilPrestador extends Perfil {

	@Lob
	private String biografia;

	@Enumerated(EnumType.STRING)
	private TipoDeServico servicoOferecido;

	public PerfilPrestador(String profilePicurl, String desciption, String biografia, TipoDeServico servicoOferecido) {
		super(profilePicurl, desciption);
		this.biografia = biografia;
		this.servicoOferecido = servicoOferecido;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public TipoDeServico getServicoOferecido() {
		return servicoOferecido;
	}

	public void setServicoOferecido(TipoDeServico servicoOferecido) {
		this.servicoOferecido = servicoOferecido;
	}

	@Override
	public String toString() {
		return "PerfilPrestador [biografia=" + biografia + ", servicoOferecido=" + servicoOferecido
				+ ", getProfilePicUrl()=" + getProfilePicUrl() + ", getDescription()=" + getDescription()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
