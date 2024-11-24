package com.coinnect.CoinNect.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public abstract class Perfil {

	@Column
	private String profilePicUrl;

	@OneToOne
	@JoinColumn(name = "usuario_id") // Esta coluna estará na tabela 'Usuario'
	private Usuario usuario;

	public Perfil(String profilePicUrl, Usuario usuario) {
		this.profilePicUrl = profilePicUrl;
		this.usuario = usuario;
	}

	public Perfil() {

	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Perfil [profilePicUrl=" + profilePicUrl + ", usuario=" + usuario + "]";
	}

}
