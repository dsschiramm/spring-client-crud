package restapi.springclientcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import restapi.springclientcrud.constraint.SexConstraint;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"cpf"})})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preenchimento do nome é obrigatório.")
    private String nome;

    @SexConstraint
    private String sexo;

    @Email(message = "Email inválido.")
    private String email;

    private String naturalidade;
    private String nacionalidade;

    @NotBlank(message = "Preenchimento do CPF é obrigatório.")
    @CPF(message = "CPF inválido")
    //@Column(unique = true)
    private String cpf;

    @NotNull(message = "Preenchimento da data de nascimento é obrigatório.")
    @PastOrPresent(message = "A data de nascimento deve ser anterior ou igual à data de hoje.")
    private Date dataNascimento;

    public void setCpf(String cpf) {
        cpf = cpf.replaceAll("[.-]", "");
        this.cpf = cpf;
    }
}
