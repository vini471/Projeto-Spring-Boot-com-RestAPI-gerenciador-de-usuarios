package com.projeto.api.service;

import com.projeto.api.dto.CategoriaDto;
import com.projeto.api.entity.CategoriaEntity;
import com.projeto.api.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    private List<CategoriaEntity> listaCategoria = new ArrayList<>();

    public boolean cadastrarCategoria(CategoriaDto categoriaDto){
        for (CategoriaEntity entity : listaCategoria){
            if (entity.getIdCategoria().equals(categoriaDto)){
                return false;
            }
            CategoriaEntity categoriaEntity = new CategoriaEntity();

            repository.save(categoriaEntity);
            return true;
        }
        return false;
    }

    public boolean deletarCategoria(CategoriaDto categoriaDto) {
        for (CategoriaEntity entity : listaCategoria) {
            if (entity.getNomeCategoria().equals(categoriaDto.getNomeCategoriaDto())) {
                listaCategoria.remove(categoriaDto);
                return true;
            }
        }
        return false;
    }

    public List<CategoriaDto> obterCategoria() {
        List<CategoriaDto> listaCategoriaDto = new ArrayList<>();

        List<CategoriaEntity> listaCategoria = repository.findAll();
        return listaCategoriaDto;
    }

}
