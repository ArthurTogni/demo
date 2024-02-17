package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
