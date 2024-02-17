package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class CadastrarBeneficiarioDTO {

    @JsonIgnore
    private Long compraId;
    private String nome;
    private Long telefone;
    private String dataNascimento;
    private Timestamp dataInclusao;
    private Timestamp dataAtualizacao;

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Timestamp dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
