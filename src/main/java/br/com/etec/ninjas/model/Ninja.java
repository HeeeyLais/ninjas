package br.com.etec.ninjas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


// anotattion(@) entity, indica que essa classe é uma tabela no BD
@Entity
// @table define o nome da tabela, caso não usado o nome da tabela no BD fica como o nome da classe(Ninja)
@Table (name="ninja")
// @data cria todos os getters e setters, refatora os dados
@Data
public class Ninja {
    // @id em cima do campo que vai ser definido como cahve primária
    @Id
            // @GeneratedValue = gerar id em ordem crescente de forma sequencial automática
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ninja;
    // id é controlado/criado automaticamente pelo banco de dados, não precisa de criar setters e getters
    // @Column = define como cada atributo será criado
        //(name=nome coluna | nullable = pode/não pode ser nulo | unique = pode/não pode ser unico)
    @Column (name = "nome_ninja", nullable = false)
    private String nome;
    @Column (name = "cpf_ninja", nullable = false, unique = true)
    private String cpf;
    @Column (name = "email_ninja", nullable = false, unique = true)
    private String email;
}