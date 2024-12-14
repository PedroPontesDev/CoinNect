package com.coinnect.CoinNect.model.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_prestador")
@DiscriminatorValue(value = "PRESTADOR_SERVICOS")
public class Prestador extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cpf_prestador")
	private String cpf;

	@Transient
	private final Double AVALICAO_MAXIMA = 5.0;

	private Double avalicao;

	@OneToMany(mappedBy = "prestador")
	private Set<Contrato> contratos = new HashSet<>();

	@OneToOne
	private Perfil perfil;

	public Prestador(Long id, String firstName, String lastName, String email, String telephone, Endereco endereco,
			String username, String password, Perfil perfil,  String cpf, Double avalicao,
			Set<Contrato> contratos) {
		super(id, firstName, lastName, email, telephone, endereco, username, password, perfil);
		this.cpf = cpf;
		this.avalicao = avalicao;
		this.contratos = contratos;
		this.perfil = perfil;
	}

	public Prestador() {

	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public Perfil getPerfil() {
		// TODO Auto-generated method stub
		return super.getPerfil();
	}

	@Override
	public void setPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		super.setPerfil(perfil);
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getTelephone() {
		// TODO Auto-generated method stub
		return super.getTelephone();
	}

	@Override
	public void setTelephone(String telephone) {
		// TODO Auto-generated method stub
		super.setTelephone(telephone);
	}

	@Override
	public Endereco getEndereco() {
		// TODO Auto-generated method stub
		return super.getEndereco();
	}

	@Override
	public void setEndereco(Endereco endereco) {
		// TODO Auto-generated method stub
		super.setEndereco(endereco);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getAvalicao() {
		return avalicao;
	}

	public void setAvalicao(Double avalicao) {
		this.avalicao = avalicao;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Double getAVALICAO_MAXIMA() {
		return AVALICAO_MAXIMA;
	}

	
	
	@Override
	public String toString() {
		return "Prestador [id=" + id + ", cpf=" + cpf + ", AVALICAO_MAXIMA=" + AVALICAO_MAXIMA + ", avalicao="
				+ avalicao + ", contratos=" + contratos + ", perfil=" + perfil + "]";
	}

	
	
}
