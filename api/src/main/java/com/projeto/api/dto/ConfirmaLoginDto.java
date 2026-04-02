package com.projeto.api.dto;

public class ConfirmaLoginDto {
    private String loginConfirma;
    private String senhaConfirma;

    public ConfirmaLoginDto() {
    }

    public String getLoginConfirma() {
        return loginConfirma;
    }

    public void setLoginConfirma(String loginConfirma) {
        this.loginConfirma = loginConfirma;
    }

    public String getSenhaConfirma() {
        return senhaConfirma;
    }

    public void setSenhaConfirma(String senhaConfirma) {
        this.senhaConfirma = senhaConfirma;
    }
}
