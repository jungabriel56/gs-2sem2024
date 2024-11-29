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
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }



}
