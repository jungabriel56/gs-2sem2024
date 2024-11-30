package br.com.fiap.jungabriel56.gs.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Painel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String modelo;

    @Column(nullable = false, length = 5)
    private int tamanho;

    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, length = 60)
    private String marca;

}
