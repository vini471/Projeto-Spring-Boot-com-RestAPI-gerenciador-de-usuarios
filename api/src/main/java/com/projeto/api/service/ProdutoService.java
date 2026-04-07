package com.projeto.api.service;

import com.projeto.api.dto.CategoriaDto;
import com.projeto.api.dto.ProdutoDto;
import com.projeto.api.entity.CategoriaEntity;
import com.projeto.api.entity.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<ProdutoEntity> listaProduto = new ArrayList<>();
    private List<CategoriaEntity>  listaCategoria = new ArrayList<>();
    private long contadorId = 1L;

    public boolean cadastrarCategoria(CategoriaDto categoriaDto){
        for (CategoriaEntity entity : listaCategoria){
            if (entity.getNomeCategoria().equals(categoriaDto)){
                return false;
            }
            CategoriaEntity categoriaEntity = new CategoriaEntity();
            categoriaEntity.setNomeCategoria(categoriaDto.getNomeCategoriaDto());
            categoriaEntity.setIdCategoria(contadorId++);

            listaCategoria.add(categoriaEntity);
            return true;
        }
        return false;
    }

    public boolean cadastraProduto(ProdutoDto produtoDto) {
        for (ProdutoEntity entity : listaProduto) {
            if (entity.getNomeProduto().equals(produtoDto.getNomeProdutoDto())) {
                return false;
            }

            ProdutoEntity produtoEntity = new ProdutoEntity();

            produtoEntity.setNomeProduto(produtoDto.getNomeProdutoDto());
            produtoEntity.setPrecoProduto(produtoDto.getPrecoProdutoDto());
            produtoEntity.setIdProduto(contadorId++);

            listaProduto.add(produtoEntity);
            return true;
        }
        return false;
    }

    public boolean deletarProduto(ProdutoDto produtoDto) {
        for (ProdutoEntity entity : listaProduto) {
            if (entity.getNomeProduto().equals(produtoDto.getNomeProdutoDto())) {
                listaProduto.remove(produtoDto);
                return true;
            }
        }
        return false;
    }

    public boolean deletarCategoria(CategoriaDto categoriaDto) {
        for (CategoriaEntity entity : listaCategoria) {
            if (entity.getNomeCategoria().equals(categoriaDto.getNomeCategoriaDto())) {
                listaProduto.remove(categoriaDto);
                return true;
            }
        }
        return false;
    }

    public List<ProdutoDto> obterProduto() {
        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        for (ProdutoEntity entity : listaProduto) {
            ProdutoDto dto = new ProdutoDto();

            dto.setNomeProdutoDto(entity.getNomeProduto());
            dto.setPrecoProdutoDto(entity.getPrecoProduto());
            dto.setIdProdutoDto(entity.getIdProduto());

            listaProdutoDto.add(dto);
        }

        return listaProdutoDto;
    }

    public List<CategoriaDto> obterCategoria() {
        List<CategoriaDto> listaCategoriaDto = new ArrayList<>();

        for (CategoriaEntity entity : listaCategoria) {
            CategoriaDto dto = new CategoriaDto();

            dto.setNomeCategoriaDto(entity.getNomeCategoria());
            dto.setIdCategoriaDto(entity.getIdCategoria());

            listaCategoriaDto.add(dto);
        }

        return listaCategoriaDto;
    }


}
