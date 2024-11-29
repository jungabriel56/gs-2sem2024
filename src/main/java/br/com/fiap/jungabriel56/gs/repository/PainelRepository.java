package br.com.fiap.jungabriel56.gs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.jungabriel56.gs.model.Painel;

@Repository
public interface PainelRepository 
	extends JpaRepository<Painel, Long> {

	<T> T findByNome(String nome, Class<T> type);
	<T> List<T> findAllByNome(String nome, Class<T> type);
	<T> List<T> findAllByNomeContains(String nome, Class<T> type);
}
