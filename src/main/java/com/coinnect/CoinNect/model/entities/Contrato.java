package com.coinnect.CoinNect.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.coinnect.CoinNect.model.enums.StatusContrato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contrato")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String conteudo; // Conteúdo detalhado do contrato

	@Lob
	private String clausulasEspecificas;

	private LocalDate dataCriacao;
	private LocalDate dataInicio;
	private LocalDate dataTermino;

	@Enumerated(EnumType.STRING)
	private StatusContrato status;

	@ManyToOne
	@JoinColumn(name = "contratante_id")
	private Contratante contratante;

	@ManyToOne
	@JoinColumn(name = "prestador_id")
	private Prestador prestador;

	@Column(name = "assinatura_prestador")
	private String assinaturaPrestador;

	@Column(name = "assinatura_contratante")
	private String assinaturaContratante;

	private BigDecimal valor;

	private boolean foiFormalizado;

	public Contrato(Long id, String conteudo, String clausulasEspecificas, LocalDate dataCriacao, LocalDate dataInicio,
			LocalDate dataTermino, StatusContrato status, Contratante contratante, Prestador prestador,
			String assinaturaPrestador, String assinaturaContratante, BigDecimal valor, boolean foiFormalizado) {
		this.id = id;
		this.conteudo = conteudo;
		this.clausulasEspecificas = clausulasEspecificas;
		this.dataCriacao = dataCriacao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.status = status;
		this.contratante = contratante;
		this.prestador = prestador;
		this.assinaturaPrestador = assinaturaPrestador;
		this.assinaturaContratante = assinaturaContratante;
		this.valor = valor;
		this.foiFormalizado = foiFormalizado;
	}

	public Contrato() {

	}

	public boolean isFoiFormalizado() {
		return foiFormalizado;
	}

	public void setFoiFormalizado(boolean foiFormalizado) {
		this.foiFormalizado = foiFormalizado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getClausulasEspecificas() {
		return clausulasEspecificas;
	}

	public void setClausulasEspecificas(String clausulasEspecificas) {
		this.clausulasEspecificas = clausulasEspecificas;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public StatusContrato getStatus() {
		return status;
	}

	public void setStatus(StatusContrato status) {
		this.status = status;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public boolean foiFormalizado() {
		return foiFormalizado;
	}

	public void foiFormalizado(boolean foiFormalizado) {
		this.foiFormalizado = foiFormalizado;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public String getAssinaturaPrestador() {
		return assinaturaPrestador;
	}

	public void setAssinaturaPrestador(String assinaturaPrestador) {
		this.assinaturaPrestador = assinaturaPrestador;
	}

	public String getAssinaturaContratante() {
		return assinaturaContratante;
	}

	public void setAssinaturaContratante(String assinaturaContratante) {
		this.assinaturaContratante = assinaturaContratante;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", conteudo=" + conteudo + ", clausulasEspecificas=" + clausulasEspecificas
				+ ", dataCriacao=" + dataCriacao + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", status=" + status + ", contratante=" + contratante + ", prestador=" + prestador
				+ ", assinaturaPrestador=" + assinaturaPrestador + ", assinaturaContratante=" + assinaturaContratante
				+ ", valor=" + valor + "]";
	}

}
