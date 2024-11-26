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
