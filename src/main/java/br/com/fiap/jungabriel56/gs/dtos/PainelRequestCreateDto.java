package br.com.fiap.jungabriel56.gs.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PainelRequestCreateDto {
    private String modelo;
    private int tamanho;
	private BigDecimal valor;
    private String marca;
}
