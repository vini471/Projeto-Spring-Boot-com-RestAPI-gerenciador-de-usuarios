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
    private long contadorId = 1L;

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
            if (entity.getNomeProduto().equals(produtoDto)) {
                listaProduto.remove(produtoDto);
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
}
