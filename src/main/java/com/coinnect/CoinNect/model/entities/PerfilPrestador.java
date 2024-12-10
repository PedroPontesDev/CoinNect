package com.coinnect.CoinNect.model.entities;

import com.coinnect.CoinNect.model.enums.TipoDeServico;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_perfil_contratantes")
@DiscriminatorValue("PERFIL_PRESTADOR")
public class PerfilPrestador extends Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PerfilPrestador [id=" + id + ", biografia=" + biografia + ", servicoOferecido=" + servicoOferecido
				+ "]";
	}

}
