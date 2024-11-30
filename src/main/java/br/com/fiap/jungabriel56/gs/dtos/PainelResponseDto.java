package br.com.fiap.jungabriel56.gs.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PainelResponseDto {
    
    private Long id;
    private String modelo;
    private int tamanho;
	private BigDecimal valor;
    private String marca;
    
   


}
