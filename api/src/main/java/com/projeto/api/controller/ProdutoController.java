package com.projeto.api.controller;

import com.projeto.api.dto.CategoriaDto;
import com.projeto.api.dto.ProdutoDto;
import com.projeto.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(/"api2")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/produto")
    public ResponseEntity<String> cadastraProdutoController(@RequestBody ProdutoDto produtoDto){
        boolean retorno = service.cadastraProduto(produtoDto);
        if (!retorno){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não cadastrado! Tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Produto cadastrado com sucesso");
        }
    }

    @PostMapping("/categoria")
    public ResponseEntity<String> cadastraCategoriaController(@RequestBody CategoriaDto categoriaDto){
        boolean retorno = service.cadastrarCategoria(categoriaDto);
        if (!retorno){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria não cadastrada! Tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Categoria cadastrada com sucesso");
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> listaProdutoController(){
        List<ProdutoDto> produtos = service.obterProduto();
        if (produtos == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(produtos);
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> listaCategoriaController(){
        List<CategoriaDto> categorias = service.obterCategoria();
        if (categorias == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categorias);
        }
    }

    @DeleteMapping("/produto/deleta/{}")
    public ResponseEntity<String> deletaProdutoController(ProdutoDto produtoDto){
        boolean retorno = service.deletarProduto(produtoDto);
        if (!retorno){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado/excluido! Tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Produto excluido com sucesso");
        }
    }

    @DeleteMapping("/produto/deleta/{}")
    public ResponseEntity<String> deletaCategoriaController(CategoriaDto categoriaDto){
        boolean retorno = service.deletarCategoria(categoriaDto);
        if (!retorno){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria não encontrada/excluida! Tente novamente!");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Categoria excluida com sucesso");
        }
    }
}
