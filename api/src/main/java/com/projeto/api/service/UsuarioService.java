package com.projeto.api.service;

import com.projeto.api.dto.*;
import com.projeto.api.entity.ProdutoEntity;
import com.projeto.api.entity.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioEntity> listaUsuario = new ArrayList<>();

    //================================================================================
    //====================================POST========================================

    public boolean cadastraUsuario(UsuarioDto dto) {
        for (UsuarioEntity usuario : listaUsuario) {
            if (usuario.getEmailUsuario().equals(dto.getEmailUsuario())) {
                return false;
            }
        }
        UsuarioEntity entity = new UsuarioEntity();

        entity.setNomeUsuario(dto.getNomeUsuario());
        entity.setEmailUsuario(dto.getEmailUsuario());
        entity.setCpfUsuario(dto.getCpfUsuario());
        entity.setSenhaUsario(dto.getSenhaUsario());
        entity.setIdadeUsuario(dto.getIdadeUsuario());

        listaUsuario.add(entity);
        return true;
    }

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

    public boolean confirmaLoginUsuario(ConfirmaLoginDto confirmaLoginDto){
        for (UsuarioEntity entity : listaUsuario){
            if (confirmaLoginDto.getLoginConfirma() != null
                    && confirmaLoginDto.getSenhaConfirma() != null
                    && confirmaLoginDto.getLoginConfirma().equals(entity.getEmailUsuario())
                    && confirmaLoginDto.getSenhaConfirma().equals(entity.getSenhaUsario())){

                return true;
            }
        }
        return false;
    }

    //================================================================================
    //====================================DELETE======================================

    public boolean deletaUsuario(UsuarioDto dto) {
        for (UsuarioEntity usuario : listaUsuario) {
            if (usuario.getEmailUsuario().equals(dto.getEmailUsuario())) {
                listaUsuario.remove(usuario);
                return true;
            }
        }
        return false;
    }

    //================================================================================
    //====================================PUT=========================================

    public boolean atualizaUsuario(AtualizaUsuarioDto dto, String login){
        for (UsuarioEntity busca : listaUsuario){
            if (busca.getEmailUsuario().equals(login)) {
                if (dto.getNomeNovo() != null) {
                    busca.setNomeUsuario(dto.getNomeNovo());
                }

                if (dto.getEmailNovo() != null) {
                    busca.setEmailUsuario(dto.getEmailNovo());
                }

                if (dto.getIdadeNovo() != 0) {
                    busca.setIdadeUsuario(dto.getIdadeNovo());
                }
                return true;
            }
        }
        return false;
    }

    //================================================================================
    //====================================GET=========================================

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

    public List<SaidaDto> procuraUsuario(ProcuraUsuarioDto procuraUsuarioDto) {
        List<SaidaDto> listaSaidaDto = new ArrayList<>();
        for (UsuarioEntity entity : listaUsuario) {
            if (entity.getEmailUsuario().equals(procuraUsuarioDto.getEmailBusca())) {
                SaidaDto saidaDto = new SaidaDto();
                saidaDto.setEmailUsuario(entity.getEmailUsuario());
                saidaDto.setNomeUsuario(entity.getNomeUsuario());
                listaSaidaDto.add(saidaDto);
            }
        }
        return listaSaidaDto;
    }
}
