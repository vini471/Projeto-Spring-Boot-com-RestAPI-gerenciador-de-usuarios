package com.projeto.api.dto;

public class UsuarioDto {

    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsario;
    private String cpfUsuario;
    private int idadeUsuario;

    public UsuarioDto() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsario() {
        return senhaUsario;
    }

    public void setSenhaUsario(String senhaUsario) {
        this.senhaUsario = senhaUsario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public int getIdadeUsuario() {
        return idadeUsuario;
    }

    public void setIdadeUsuario(int idadeUsuario) {
        this.idadeUsuario = idadeUsuario;
    }
}
