package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class CadastrarDocumentoDTO {

    @JsonIgnore
    private Long id;
    private String tipoDocumento;
    private String descricao;
    private Timestamp datainclusao;
    private Timestamp dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Timestamp datainclusao) {
        this.datainclusao = datainclusao;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
