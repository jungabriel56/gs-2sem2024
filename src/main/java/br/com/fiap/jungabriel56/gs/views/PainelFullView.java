package br.com.fiap.jungabriel56.gs.views;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface PainelFullView {
    String modelo();
    int tamanho();
	BigDecimal valor();
    String marca();

    @Value("#{target.id + '/' + target.modelo}")
    String getDescricao();
    
    BigDecimal getValor();

    @Value("#{target.valor * 1.15}")
    String getResultado();

}
