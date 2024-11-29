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

import br.com.fiap.jungabriel56.gs.dtos.PainelRequestCreateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelRequestUpdateDto;
import br.com.fiap.jungabriel56.gs.dtos.PainelResponseDto;
import br.com.fiap.jungabriel56.gs.mapper.PainelMapper;
import br.com.fiap.jungabriel56.gs.repository.PainelRepository;
import br.com.fiap.jungabriel56.gs.service.PainelService;
import br.com.fiap.jungabriel56.gs.views.PainelFullView;
import br.com.fiap.jungabriel56.gs.views.PainelSimpleView;
import br.com.fiap.jungabriel56.gs.views.PainelViewType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
                @RequestParam String modelo, 
                PainelViewType type) { 

        switch (type) {
            case FULL:
                return ResponseEntity.ok().body(painelRepository.findAllByNomeContains(modelo, PainelFullView.class));                
            case SIMPLE:
                return ResponseEntity.ok().body(painelRepository.findAllByNomeContains(modelo, PainelSimpleView.class));            
        }
        return ResponseEntity.noContent().build();
    }
}