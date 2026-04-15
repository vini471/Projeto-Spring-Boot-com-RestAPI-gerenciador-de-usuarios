package com.projeto.api.entity;

import com.projeto.api.dto.CategoriaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long id;

    @Column(name = "nomeCategoria")
    private String nome;

    public CategoriaEntity() {
    }

    public CategoriaEntity(CategoriaDto categoriaDto) {
        if (categoriaDto.getIdCategoriaDto() > 0L) {
            this.id = categoriaDto.getIdCategoriaDto();
        }
        this.nome = categoriaDto.getNomeCategoriaDto();
    }

    public String getNomeCategoria() {
        return nome;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nome = nomeCategoria;
    }

    public Long getIdCategoria() {
        return id;
    }

    public void setIdCategoria(Long idCategoria) {
        this.id = id;
    }
}
