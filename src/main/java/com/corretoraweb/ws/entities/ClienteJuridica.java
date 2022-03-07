package com.corretoraweb.ws.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente_juricia_clj", schema = "corretora_web")
public class ClienteJuridica {
    @Id
    private Long id;
    @CNPJ
    @Size(max = 14, min = 14,  message = "cnpj: deve ter 14 caracteres")
    @NotEmpty(message = "cnpj: Campo não deve ser vazio")
    @Column(name = "cpnj", unique = true)
    private String cpnj;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "clt_id_int", nullable = false)
    private Cliente cliente;


}
