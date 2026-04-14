package com.projeto.api.controller;

import com.projeto.api.dto.CategoriaDto;
import com.projeto.api.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/categoria")
    public ResponseEntity<String> cadastrar(@RequestBody CategoriaDto categoriaDto){
        boolean retorno = service.cadastrarCategoria(categoriaDto);
        if (!retorno){
            return ResponseEntity
                    .status(HttpStatus
                            .BAD_REQUEST)
                    .body("Não foi possivel cadastrar nova categoria! Cheque as informações e tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Categoria cadastrada com sucesso!");
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> obter(){
        List<CategoriaDto> lista = service.obterCategoria();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
