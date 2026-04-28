package com.projeto.api.entity;

import com.projeto.api.dto.ProdutoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoriaEntity;

    public ProdutoEntity() {
    }

    public ProdutoEntity(ProdutoDto produtoDto) {
        if (produtoDto.getIdProdutoDto() > 0L){
            this.id = produtoDto.getIdProdutoDto();
        }
        this.id = produtoDto.getIdProdutoDto();
        this.nome = produtoDto.getNomeProdutoDto();
        this.preco = produtoDto.getPrecoProdutoDto();
    }

    public double getPrecoProduto() {
        return preco;
    }

    public void setPrecoProduto(double precoProduto) {
        this.preco = precoProduto;
    }

    public String getNomeProduto() {
        return nome;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nome = nomeProduto;
    }

    public Long getIdProduto() {
        return id;
    }

    public void setIdProduto(Long idProduto) {
        this.id = idProduto;
    }

}
