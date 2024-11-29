package br.com.fiap.jungabriel56.gs.dtos;

import java.math.BigDecimal;

public class PainelRequestUpdateDto {

    private String modelo;
    private int tamanho;
	private BigDecimal valor;
    private String marca;
    
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
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
   
}
