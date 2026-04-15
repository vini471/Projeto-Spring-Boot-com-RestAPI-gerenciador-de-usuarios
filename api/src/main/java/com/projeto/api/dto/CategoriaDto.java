package com.projeto.api.dto;

public class CategoriaDto {
    private String nome;
    private long id;

    public CategoriaDto() {
    }

    public String getNomeCategoriaDto() {
        return nome;
    }

    public void setNomeCategoriaDto(String nomeCategoriaDto) {
        this.nome = nomeCategoriaDto;
    }

    public long getIdCategoriaDto() {
        return id;
    }

    public void setIdCategoriaDto(long idCategoriaDto) {
        this.id = idCategoriaDto;
    }
}
