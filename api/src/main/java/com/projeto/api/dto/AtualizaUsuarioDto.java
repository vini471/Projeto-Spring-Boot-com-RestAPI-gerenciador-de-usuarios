package com.projeto.api.dto;

public class AtualizaUsuarioDto {
    private String nomeNovo;
    private String emailNovo;
    private int idadeNovo;

    public AtualizaUsuarioDto() {
    }

    public String getNomeNovo() {
        return nomeNovo;
    }

    public void setNomeNovo(String nomeNovo) {
        this.nomeNovo = nomeNovo;
    }

    public String getEmailNovo() {
        return emailNovo;
    }

    public void setEmailNovo(String emailNovo) {
        this.emailNovo = emailNovo;
    }

    public int getIdadeNovo() {
        return idadeNovo;
    }

    public void setIdadeNovo(int idadeNovo) {
        this.idadeNovo = idadeNovo;
    }
}
