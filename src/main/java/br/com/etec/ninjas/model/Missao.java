package br.com.etec.ninjas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "missao")
@Data
@Valid
public class Missao {
    @Id
        @GeneratedValue (strategy = GenerationType.SEQUENCE)
        private Long id_missao;

    @Column (name = "nome_missao", nullable = false)
        @NotBlank(message = "Nome é obrigatório.")
        private String nome;

    @Column (name = "descricao", nullable = false)
        @NotBlank(message = "Descrição é obrigatória.")
        @Size(min = 20, max = 300, message = "Descrição deve ter entre 20 e 300 caracteres")
        private String descricao;

    @Column (name = "dificuldade", nullable = false)
        @NotBlank(message = "Dificuldade é obrigatória")
        @Size (min = 1, max = 1, message = "Dificuldade deve ter um caracter")
        private String dificuldade;
    
}
