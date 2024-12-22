package com.coinnect.CoinNect.model.dtos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerfilContratanteDTO {

    private Long id;

    @NotBlank(message = "O primeiro nome é obrigatório.")
    private String firstName;

    private String lastName;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,15}", message = "O telefone deve conter entre 10 e 15 dígitos.")
    private String telephone;

    @NotNull(message = "O endereço é obrigatório.")
    private EnderecoDTO endereco;

    @NotBlank(message = "O campo CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos.")
    private String cpf;

    @NotBlank(message = "O campo CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos.")
    private String cnpj;

    @NotBlank(message = "O campo password é obrigatório.")
    private String password;

    private String username;

    public PerfilContratanteDTO() {
    }

    public PerfilContratanteDTO(Long id, String firstName, String lastName, String email, String telephone, EnderecoDTO endereco,
            String cpf, String cnpj, String password, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.password = password;
        this.username = username;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // hashCode, equals e toString
    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PerfilContratanteDTO that = (PerfilContratanteDTO) obj;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public String toString() {
        return "ContratanteDTO{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", email='" + email + '\'' + ", telephone='" + telephone + '\'' + ", endereco=" + endereco + ", cpf='"
                + cpf + '\'' + ", cnpj='" + cnpj + '\'' + '}';
    }
}
