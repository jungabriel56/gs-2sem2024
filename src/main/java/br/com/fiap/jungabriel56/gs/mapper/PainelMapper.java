package br.com.fiap.jungabriel56.gs.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.jungabriel56.gs.dtos.PainelRequestCreateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelRequestUpdateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelResponseDto;
import br.com.fiap.jungabriel56.gs.model.Painel;

@Component
public class PainelMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PainelResponseDto toDto(Painel painel){
        return modelMapper.map(painel, PainelResponseDto.class);
    }

    public Painel toModel(PainelRequestCreateDto dto) {
        return modelMapper.map(dto, Painel.class);
    }

    public Painel toModel(Long id, PainelRequestUpdateDto dto) {
        Painel result = modelMapper.map(dto, Painel.class);
        result.setId(id);
        return result;
    } 
}
