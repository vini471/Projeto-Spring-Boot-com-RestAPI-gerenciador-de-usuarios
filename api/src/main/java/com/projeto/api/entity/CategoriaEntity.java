package com.projeto.api.entity;

import com.projeto.api.dto.CategoriaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long idCategoria;

    @Column(name = "nomeCategoria")
    private String nomeCategoria;

    public CategoriaEntity() {
    }

    public CategoriaEntity(CategoriaDto categoriaDto) {
        this.idCategoria = categoriaDto.getIdCategoriaDto();
        this.nomeCategoria = categoriaDto.getNomeCategoriaDto();
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
