package com.projeto.api.dto;

public class ProdutoDto {
    private String nomeProdutoDto;
    private double precoProdutoDto;
    private long idProdutoDto;

    public ProdutoDto() {
    }

    public String getNomeProdutoDto() {
        return nomeProdutoDto;
    }

    public void setNomeProdutoDto(String nomeProdutoDto) {
        this.nomeProdutoDto = nomeProdutoDto;
    }

    public double getPrecoProdutoDto() {
        return precoProdutoDto;
    }

    public void setPrecoProdutoDto(double precoProdutoDto) {
        this.precoProdutoDto = precoProdutoDto;
    }

    public long getIdProdutoDto() {
        return idProdutoDto;
    }

    public void setIdProdutoDto(long idProdutoDto) {
        this.idProdutoDto = idProdutoDto;
    }
}
