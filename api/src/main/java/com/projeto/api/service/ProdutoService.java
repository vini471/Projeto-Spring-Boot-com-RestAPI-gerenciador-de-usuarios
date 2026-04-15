package com.projeto.api.service;

import com.projeto.api.dto.CategoriaDto;
import com.projeto.api.dto.ProdutoDto;
import com.projeto.api.entity.CategoriaEntity;
import com.projeto.api.entity.ProdutoEntity;
import com.projeto.api.repository.CategoriaRepository;
import com.projeto.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<ProdutoEntity> listaProduto = new ArrayList<>();

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrarProduto(ProdutoDto produtoDto){
        ProdutoEntity entity = new ProdutoEntity(produtoDto);

        repository.save(entity);
        return true;
    }

    public List<ProdutoDto> obterProduto(){
        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        List<ProdutoEntity> listaProduto = repository.findAll();
        return listaProdutoDto;
    }


}
