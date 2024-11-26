package com.coinnect.CoinNect.model.entities;

import com.coinnect.CoinNect.model.enums.TipoDeServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_")
public class PerfilContratante extends Perfil {

	@Lob
	private String biografia;

	@Enumerated(EnumType.STRING)
	private TipoDeServico servicosEmInteresee;

	public PerfilContratante(String profilePicurl, String desciption, String biografia) {
		super(profilePicurl, desciption);
		this.biografia = biografia;
	}

	public PerfilContratante() {

	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public TipoDeServico getServicosEmInteresee() {
		return servicosEmInteresee;
	}

	public void setServicosEmInteresee(TipoDeServico servicosEmInteresee) {
		this.servicosEmInteresee = servicosEmInteresee;
	}

	@Override
	public String toString() {
		return "PerfilContratante [biografia=" + biografia + "]";
	}

}
