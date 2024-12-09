package com.coinnect.CoinNect.model.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_perfil")
public abstract class Perfil {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String profilePicUrl;

	private String description;

	public Perfil(String profilePicUrl, String description) {
		this.profilePicUrl = profilePicUrl;
		this.description = description;
	}

	public Perfil() {

	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	@Override
	public String toString() {
		return "Perfil [profilePicUrl=" + profilePicUrl + "]";
	}

}
