package com.projeto.api.dto;

public class CategoriaDto {
    private String nomeCategoriaDto;
    private long idCategoriaDto;

    public CategoriaDto() {
    }

    public String getNomeCategoriaDto() {
        return nomeCategoriaDto;
    }

    public void setNomeCategoriaDto(String nomeCategoriaDto) {
        this.nomeCategoriaDto = nomeCategoriaDto;
    }

    public long getIdCategoriaDto() {
        return idCategoriaDto;
    }

    public void setIdCategoriaDto(long idCategoriaDto) {
        this.idCategoriaDto = idCategoriaDto;
    }
}
