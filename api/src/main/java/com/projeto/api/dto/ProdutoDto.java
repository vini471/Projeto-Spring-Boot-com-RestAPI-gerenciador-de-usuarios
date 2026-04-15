package com.projeto.api.dto;

public class ProdutoDto {
    private String nome;
    private double preco;
    private long id;
    private long idCategoria;

    public ProdutoDto() {
    }

    public String getNomeProdutoDto() {
        return nome;
    }

    public void setNomeProdutoDto(String nomeProdutoDto) {
        this.nome = nomeProdutoDto;
    }

    public double getPrecoProdutoDto() {
        return preco;
    }

    public void setPrecoProdutoDto(double precoProdutoDto) {
        this.preco = precoProdutoDto;
    }

    public long getIdProdutoDto() {
        return id;
    }

    public void setIdProdutoDto(long idProdutoDto) {
        this.id = id;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
