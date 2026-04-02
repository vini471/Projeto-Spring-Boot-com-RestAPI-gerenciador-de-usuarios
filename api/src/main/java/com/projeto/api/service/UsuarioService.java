package com.projeto.api.service;

import com.projeto.api.dto.ConfirmaLoginDto;
import com.projeto.api.dto.SaidaDto;
import com.projeto.api.dto.TrocaSenhaDto;
import com.projeto.api.dto.UsuarioDto;
import com.projeto.api.entity.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioEntity> listaUsuario = new ArrayList<>();

    public boolean cadastraUsuario(UsuarioDto dto) {
        for (UsuarioEntity usuario : listaUsuario) {
            if (usuario.getEmailUsuario().equals(dto.getEmailUsuario())) {
                return false;
            }
            usuario.setEmailUsuario(dto.getEmailUsuario());
            usuario.setCpfUsuario(dto.getCpfUsuario());
            usuario.setNomeUsuario(dto.getNomeUsuario());
            usuario.setSenhaUsario(dto.getSenhaUsario());
            usuario.setIdadeUsuario(dto.getIdadeUsuario());

            listaUsuario.add(usuario);
            return true;
        }
        return false;
    }

    public boolean deletaUsuario(UsuarioDto dto) {
        for (UsuarioEntity usuario : listaUsuario) {
            if (usuario.getEmailUsuario().equals(dto.getEmailUsuario())) {
                listaUsuario.remove(usuario);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean confirmaLoginUsuario(ConfirmaLoginDto confirmaLoginDto){
        for (UsuarioEntity entity : listaUsuario){
            if (entity.getEmailUsuario().equals(confirmaLoginDto.getLoginConfirma())){
                if (!entity.getSenhaUsario().equals(confirmaLoginDto.getSenhaConfirma())){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean atualizaUsuario(String login, UsuarioDto usuarioDto){
        for (UsuarioEntity entity : listaUsuario){
            if (entity.getEmailUsuario().equals(login)){
                entity.setSenhaUsario(usuarioDto.getSenhaUsario());
                entity.setNomeUsuario(usuarioDto.getNomeUsuario());
                entity.setEmailUsuario(usuarioDto.getEmailUsuario());
                entity.setIdadeUsuario(usuarioDto.getIdadeUsuario());

                return true;
            }
        }
        return false;
    }

    /*public boolean atualizaUsuario(UsuarioDto usuarioDto){
        for (UsuarioEntity entity : listaUsuario){
            if (entity.getEmailUsuario().equals(usuarioDto.getEmailUsuario())){

            }
        }
    }*/

    public boolean trocaSenhaUsuario(String email, TrocaSenhaDto trocaSenhaDto) {
        for (UsuarioEntity entity : listaUsuario) {
            /*if (entity.getSenhaUsario().equals(trocaSenhaDto.getSenhaAtual())
                    && trocaSenhaDto.getSenhaNova().equals(trocaSenhaDto.getSenhaNovaConfirma())
                    && entity.getEmailUsuario().equals(email)) {
                entity.setSenhaUsario(trocaSenhaDto.getSenhaNova());
                return true;
            }*/
            if (entity.getEmailUsuario().equals(email)) {

            if (!entity.getSenhaUsario().equals(trocaSenhaDto.getSenhaAtual())) {
                return false;
            }
            if (!trocaSenhaDto.getSenhaNova().equals(trocaSenhaDto.getSenhaNovaConfirma())) {
                return false;
            } }
            entity.setSenhaUsario(trocaSenhaDto.getSenhaNovaConfirma());
            return true;


        }
        return false;
    }

    public List<SaidaDto> obterUsuario() {
        List<SaidaDto> listaObterUsuario = new ArrayList<>();
        UsuarioDto usuarioDto = new UsuarioDto();
        for (UsuarioEntity entity : listaUsuario) {
            SaidaDto saidaDto = new SaidaDto();

            saidaDto.setEmailUsuario(entity.getEmailUsuario());
            saidaDto.setNomeUsuario(entity.getNomeUsuario());

            listaObterUsuario.add(saidaDto);

        }
        return listaObterUsuario;
    }

    public List<SaidaDto> procuraUsuario(String emailProcura) {
        List<SaidaDto> listaSaidaDto = new ArrayList<>();
        for (UsuarioEntity entity : listaUsuario) {
            if (entity.getEmailUsuario().equals(emailProcura)) {
                SaidaDto saidaDto = new SaidaDto();
                saidaDto.setEmailUsuario(entity.getEmailUsuario());
                saidaDto.setNomeUsuario(entity.getNomeUsuario());
                System.out.println(listaUsuario);
            }
        }
        return null;
    }

}
