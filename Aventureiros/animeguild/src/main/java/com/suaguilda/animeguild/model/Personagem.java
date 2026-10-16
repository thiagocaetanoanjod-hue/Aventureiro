package com.suaguilda.animeguild.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Todo herói precisa de um nome!")
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres.")
    private String nome;

    @NotNull(message = "Selecione a classe do personagem.")
    @Enumerated(EnumType.STRING)
    private ClasseHeroi classe;

    @Min(value = 1, message = "O nível mínimo é 1.")
    @Max(value = 100, message = "O nível máximo é 100.")
    private Integer nivel;
   
}