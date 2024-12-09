package com.coinnect.CoinNect.model.entities;

import com.coinnect.CoinNect.model.enums.TipoDeServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_perfil_contratante")
public class PerfilContratante extends Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String biografia;

	@Enumerated(EnumType.STRING)
	private TipoDeServico servicosEmInteresse;

	public PerfilContratante(String profilePicUrl, String description, String biografia,
			TipoDeServico servicosEmInteresse) {
		super(profilePicUrl, description);
		this.biografia = biografia;
		this.servicosEmInteresse = servicosEmInteresse;
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
		return servicosEmInteresse;
	}

	public void setServicosEmInteresee(TipoDeServico servicosEmInteresse) {
		this.servicosEmInteresse = servicosEmInteresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeServico getServicosEmInteresse() {
		return servicosEmInteresse;
	}

	public void setServicosEmInteresse(TipoDeServico servicosEmInteresse) {
		this.servicosEmInteresse = servicosEmInteresse;
	}

	@Override
	public String toString() {
		return "PerfilContratante [id=" + id + ", biografia=" + biografia + ", servicosEmInteresse="
				+ servicosEmInteresse + "]";
	}

	
	
}
