package br.com.fiap.jungabriel56.gs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.jungabriel56.gs.dtos.PainelRequestCreateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelRequestUpdateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelResponseDto;
import br.com.fiap.jungabriel56.gs.mapper.PainelMapper;
import br.com.fiap.jungabriel56.gs.model.Painel;
import br.com.fiap.jungabriel56.gs.repository.PainelRepository;
import br.com.fiap.jungabriel56.gs.service.PainelService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/paineis")
@RequiredArgsConstructor
public class PainelController {    
    
    private final PainelService painelService;
    private final PainelMapper painelMapper;
    private final PainelRepository painelRepository;
    

    @GetMapping
    public ResponseEntity<List<PainelResponseDto>> list() {
        List<PainelResponseDto> dtos = painelService.list()
            .stream()
            .map(e -> painelMapper.toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PainelResponseDto> create(@RequestBody PainelRequestCreateDto dto) {        

        System.out.println(dto.getMarca());
        System.out.println(dto.getModelo());
        System.out.println(dto.getTamanho());
        System.out.println(dto.getValor());

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			painelMapper.toDto(
        					painelService.save(painelMapper.toModel(dto)))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<PainelResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody PainelRequestUpdateDto dto) {
        if (! painelService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			painelMapper.toDto(
        				painelService.save(painelMapper.toModel(id, dto)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! painelService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        painelService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<PainelResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				painelService
    					.findById(id)
    					.map(e -> painelMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);    	  		     
    }
    
    @GetMapping("/modelo")
    public  ResponseEntity<?> findByModelo(
                @RequestParam String modelo) { 


        return ResponseEntity.ok().body(painelRepository.findAllByModeloContains(modelo, Painel.class));
    }
}