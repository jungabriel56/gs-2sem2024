package br.com.fiap.jungabriel56.gs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.jungabriel56.gs.model.Painel;
import br.com.fiap.jungabriel56.gs.repository.PainelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PainelService {
    private final PainelRepository painelRepository;

    public List<Painel> list() {
        return painelRepository.findAll();
    }

    public Painel save(Painel painel) {        
        return painelRepository.save(painel);
    }

    public boolean existsById(Long id) {        
        return painelRepository.existsById(id);
    }

    public void delete(Long id) {
        painelRepository.deleteById(id);
    }

    public Optional<Painel> findById(Long id) {
        return painelRepository.findById(id);
    }
    
   
}
