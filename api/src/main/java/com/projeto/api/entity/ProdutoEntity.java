package com.projeto.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto")
    private Long idProduto;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "precoProduto")
    private double precoProduto;

    @ManyToOne
    @JoinColumn(name = "id_Categoria")
    private Long idCategoria;

    public ProdutoEntity() {
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
