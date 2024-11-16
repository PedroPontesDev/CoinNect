package com.coinnect.CoinNect.model.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.coinnect.CoinNect.model.enums.StatusContrato;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ContratoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String conteudo;
    private String clausulasEspecificas;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataTermino;

    private StatusContrato status;
    private String assinaturaPrestador;
    private String assinaturaContratante;
    private BigDecimal valor;

    // IDs das entidades relacionadas
    private Long contratanteId;
    private Long prestadorId;

    // Construtor vazio
    public ContratoDTO() {}

    // Construtor completo
    public ContratoDTO(Long id, String conteudo, String clausulasEspecificas, LocalDate dataCriacao, LocalDate dataInicio,
                       LocalDate dataTermino, StatusContrato status, String assinaturaPrestador,
                       String assinaturaContratante, BigDecimal valor, Long contratanteId, Long prestadorId) {
        this.id = id;
        this.conteudo = conteudo;
        this.clausulasEspecificas = clausulasEspecificas;
        this.dataCriacao = dataCriacao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
        this.assinaturaPrestador = assinaturaPrestador;
        this.assinaturaContratante = assinaturaContratante;
        this.valor = valor;
        this.contratanteId = contratanteId;
        this.prestadorId = prestadorId;
    }

    // Getters e Setters
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

    public Long getContratanteId() {
        return contratanteId;
    }

    public void setContratanteId(Long contratanteId) {
        this.contratanteId = contratanteId;
    }

    public Long getPrestadorId() {
        return prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
        this.prestadorId = prestadorId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoDTO other = (ContratoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ContratoDTO [id=" + id + ", conteudo=" + conteudo + ", clausulasEspecificas=" + clausulasEspecificas
				+ ", dataCriacao=" + dataCriacao + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", status=" + status + ", assinaturaPrestador=" + assinaturaPrestador + ", assinaturaContratante="
				+ assinaturaContratante + ", valor=" + valor + ", contratanteId=" + contratanteId + ", prestadorId="
				+ prestadorId + "]";
	}
    
    
}
