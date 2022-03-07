package com.corretoraweb.ws.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente_fisica_clf", schema = "corretora_web")
public class ClienteFisica {
    @Id
    private Long id;
    @CPF
    @Size(max = 11, min = 11,  message = "cpj: deve ter 11 caracteres")
    @NotEmpty(message = "cpf: Campo não deve ser vazio")
    @Column(name = "cpf", unique = true)
    private String cpf;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne()
    @JoinColumn(name = "clt_id_int", nullable = false)
    private Cliente cliente;
}
