package com.projeto.api.controller;

import com.projeto.api.dto.*;
import com.projeto.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastraUsuarioController(@RequestBody UsuarioDto usuarioDto) {
        boolean retorno = service.cadastraUsuario(usuarioDto);
        if (!retorno) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Usuario não adiconado/Dados inálidos! Verifique as informações e tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuaro cadastrado com sucesso!");
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletaUsuarioController(@RequestBody UsuarioDto usuarioDto) {
        boolean retorno = service.deletaUsuario(usuarioDto);
        if (!retorno) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Usuario não encontrado/excluido! Verifique as informações e tente novamente!");
        } else {
            return ResponseEntity.ok().body("Usuario deletado com sucesso!");
        }
    }

    @PostMapping("/autentificacao")
    public ResponseEntity<String> confirmaUsuarioController(@RequestBody ConfirmaLoginDto confirmaLoginDto) {
        boolean retorno = service.confirmaLoginUsuario(confirmaLoginDto);
        if (!retorno) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Senha ou email inválido! Tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Autentificação aprovada!");
        }
    }

    @PostMapping("/altera")
    public ResponseEntity<String> alteraSenhaController(@PathVariable String email,
                                                        @RequestBody TrocaSenhaDto trocaSenhaDto) {
        boolean retorno = service.trocaSenhaUsuario(email, trocaSenhaDto);
        if (!retorno) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha inválida! Cheque as informações e tente novamente!");
        } else {
            return ResponseEntity.ok("Senha alterada com sucesso");
        }
    }

    @PutMapping("/atualiza/{login}")
    public ResponseEntity<String> atualizaUsuarioController(@PathVariable String login,
                                                            @RequestBody AtualizaUsuarioDto atualizaUsuarioDto) {
        boolean retorno = service.atualizaUsuario(atualizaUsuarioDto, login);
        if (!retorno) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario/informações inválidas! cheque as informações e tente novamente!");
        } else {
            return ResponseEntity.ok().body("Usuario atualizado com sucesso!");
        }
    }

        @GetMapping("/obter")
        public ResponseEntity<List<SaidaDto>> listaUsuarioController() {
            List<SaidaDto> usuarios = service.obterUsuario();

            if (usuarios == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            } else {
                return ResponseEntity.ok(usuarios);
            }
        }

    }

