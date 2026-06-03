package br.com.etec.ninjas.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


// anotattion(@) entity, indica que essa classe é uma tabela no BD
@Entity
// @table define o nome da tabela, caso não usado o nome da tabela no BD fica como o nome da classe(Ninja)
@Table (name="ninja")
// @data cria todos os getters e setters, refatora os dados
@Data
//@Valid é usada para ativar a validação automática doas dados recebidos pela aplicação, verifica se as regras definidas na entidade(tipo @notBlank) estao sendo respietadas antes do processamento e salvamento
@Valid
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
    //validar campo de texto impedindo q seljam valores nulos, vazios ou com apenas espaços em branco
        @NotBlank(message = "Nome é obrigatório.")
    // size = definir tamanho minimo e máximo do valor
        @Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 10 caracteres")
    private String nome;

    @Column (name = "cpf_ninja", nullable = false, unique = true)
    @CPF
    private String cpf;

    @Email(message = "Email inválido!")
    @Column (name = "email_ninja", nullable = false, unique = true)
    private String email;
}