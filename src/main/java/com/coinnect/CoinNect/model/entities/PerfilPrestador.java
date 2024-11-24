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
	
	public PerfilPrestador(String profilePicUrl, Usuario usuario, String biografia) {
		super(profilePicUrl, usuario);
		this.biografia = biografia;
	}

	@Override
	public String getProfilePicUrl() {
		// TODO Auto-generated method stub
		return super.getProfilePicUrl();
	}

	@Override
	public void setProfilePicUrl(String profilePicUrl) {
		// TODO Auto-generated method stub
		super.setProfilePicUrl(profilePicUrl);
	}

	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return super.getUsuario();
	}

	@Override
	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		super.setUsuario(usuario);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
