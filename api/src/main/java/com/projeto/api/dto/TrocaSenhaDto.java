package com.projeto.api.dto;

public class TrocaSenhaDto {
    private String senhaAtual;
    private String senhaNova;
    private String senhaNovaConfirma;

    public TrocaSenhaDto() {
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public String getSenhaNovaConfirma() {
        return senhaNovaConfirma;
    }

    public void setSenhaNovaConfirma(String senhaNovaConfirma) {
        this.senhaNovaConfirma = senhaNovaConfirma;
    }
}
